package me.appz4.beacon.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
//import org.apache.velocity.app.VelocityEngine;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.appz4.beacon.dao.TokenDao;
import me.appz4.beacon.dao.UserDao;
import me.appz4.beacon.dao.UserLocationDao;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.model.model.Token;
import me.appz4.beacon.model.model.Token.Type;
import me.appz4.beacon.model.model.User;
import me.appz4.beacon.model.model.User.Statuses;
import me.appz4.beacon.model.model.UserConfig;
import me.appz4.beacon.model.model.UserLocation;
import me.appz4.beacon.model.model.UserWithToken;
import me.appz4.beacon.security.PasswordHasher;
import me.appz4.beacon.service.base.AbstractServiceImpl;

public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserLocationDao userLocationDao;

    @Autowired
    private PasswordHasher passwordHasher;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private SimpleMailMessage basicEmailMessage;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Transactional(value = "services")
    public User createUser(String email, String username, String password, String fullname, String phone, String icon, Integer privacy) throws Exception {
        if (checkUserEmail(email) != null) throw new ServiceException(Errors.ERROR_EMAIL_EXISTS, email);
        if (!checkUserName(username)) throw new ServiceException(Errors.ERROR_USERNAME_EXISTS, username);
        User u = new User();
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(passwordHasher.hash(password));
        Date now = Calendar.getInstance().getTime();
        u.setCreated(now);
        u.setModified(now);
        u.setPhone(phone);
        u.setFullname(fullname);
        u.setIcon(icon);
        u.setPrivacy(privacy);
        u.setVerified(0);
        try {
            UserConfig config = new UserConfig();
            config.putValue(UserConfig.FIELD_LOCATION, true);
            config.putValue(UserConfig.FIELD_PHONE, false);
            ObjectMapper mapper = new ObjectMapper();
            String res = mapper.writeValueAsString(config);
            u.setConfig(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        u.setStatus(User.Statuses.ACTIVE);
        Long userId = userDao.create(u);
        u.setId(userId);
        return u;
    }

    @Override
    @Transactional(value = "services")
    public UserWithToken loginUser(String email, String password) throws Exception {
        User u = userDao.find(
                Restrictions.eq(User.EMAIL, email),
                Restrictions.eq(User.PASSWORD, passwordHasher.hash(password)),
                Restrictions.eq(User.STATUS, User.Statuses.ACTIVE)
        );
        if (u == null) {
            throw new ServiceException(Errors.LOGIN_FAILED);
        }
        UserWithToken uToken = new UserWithToken();
        uToken.setUser(u);
        Token t = getOrCreateToken(u, Type.LOGIN);
        uToken.setToken(t);
        return uToken;
    }

    @Override
    @Transactional(value = "services")
    public UserWithToken loginUserByToken(String tk) throws Exception {
        Token token = tokenDao.find(Restrictions.eq(Token.TOKEN, tk));
        if (token == null) throw new ServiceException(Errors.LOGIN_FAILED);
        User u = userDao.find(
                Restrictions.eq(User.ID, token.getUserId()),
                Restrictions.eq(User.STATUS, User.Statuses.ACTIVE)
        );
        if (u == null) {
            throw new ServiceException(Errors.LOGIN_FAILED);
        }
        UserWithToken uToken = new UserWithToken();
        uToken.setUser(u);
        uToken.setToken(token);
        return uToken;
    }

    private Token getOrCreateToken(User u, Token.Type type) throws Exception {
        Token token = tokenDao.find(
                Restrictions.eq(Token.USERID, u.getId()),
                Restrictions.eq(Token.TYPE, type)
        );
        if (token == null) {
            token = new Token();
            token.setToken(createToken());
            token.setUserId(u.getId());
            token.setType(type);
            token.setCreated(Calendar.getInstance().getTime());
            Long id = tokenDao.create(token);
            token.setId(id);
        }
        return token;
    }

    private String createToken() throws Exception {
        String token = UUID.randomUUID().toString();
        Token t = tokenDao.find(Restrictions.eq(Token.TOKEN, token));
        if (t != null) return createToken();
        return token;
    }

    @Override
    @Transactional(value = "services")
    public User checkUserEmail(String email) throws Exception {
        return userDao.find(Restrictions.eq(User.EMAIL, email));
    }

    @Override
    @Transactional(value = "services")
    public boolean checkUserName(String username) throws Exception {
        if (userDao.find(Restrictions.eq(User.USERNAME, username)) != null) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(value = "services")
    public User isUserActive(Long userId) throws Exception {
        return userDao.find(
                Restrictions.eq(User.ID, userId),
                Restrictions.eq(User.STATUS, Statuses.ACTIVE)
        );
    }

    @Override
    @Transactional(value = "services")
    public void logoutUserByToken(String tk) throws Exception {
        Token token = tokenDao.find(Restrictions.eq(Token.TOKEN, tk));
        if (token == null) throw new ServiceException(Errors.LOGOUT_FAILED);
        tokenDao.delete(token);
    }

    @Override
    @Transactional(value = "services")
    public void deleteUser(Long userId) throws Exception {
        User user = userDao.find(Restrictions.eq(User.ID, userId), Restrictions.eq(User.STATUS, User.Statuses.ACTIVE));
        if (user == null) throw new ServiceException(Errors.LOGIN_FAILED);
    }

    @Override
    @Transactional(value = "services")
    public void updateUser(User user, String newPassword) throws Exception {
        if (newPassword != null) {
            user.setPassword(passwordHasher.hash(newPassword));
        }
        user.setModified(new Date());
        userDao.update(user);
    }

    @Override
    @Transactional(value = "services")
    public List<UserLocation> getNearUsers() throws Exception {
        return userLocationDao.findAll();
    }

    @Override
    @Transactional(value = "services")
    public UserLocation createUserLocation(Long userId, Position pos) throws Exception {
        UserLocation loc = new UserLocation();
        loc.setUserId(userId);
        loc.setLatitude(pos.getLatitude());
        loc.setLongitude(pos.getLongitude());
        loc.setCreated(Calendar.getInstance().getTime());
        Long id = userLocationDao.create(loc);
        loc.setId(id);
        return loc;
    }

    @Override
    @Transactional(value = "services")
    public List<UserLocation> getNearUsers(Position ne, Position sw, List<Long> userIds) throws Exception {
        System.out.println("NE: " + ne);
        System.out.println("SW: " + sw);
        System.out.println("USER IDS: " + userIds);
        Position nw = new Position();
        nw.setLongitude(ne.getLatitude());
        nw.setLatitude(sw.getLongitude());
        Position se = new Position();
        se.setLongitude(sw.getLatitude());
        se.setLatitude(ne.getLongitude());
        List<Criterion> parameters = new ArrayList<>();
        parameters.add(Restrictions.in(UserLocation.USERID, userIds));
        parameters.add(Restrictions.le(UserLocation.LATITUDE, ne.getLatitude()));
        parameters.add(Restrictions.ge(UserLocation.LATITUDE, sw.getLatitude()));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.desc(UserLocation.CREATED));
        List<Projection> pr = new ArrayList<>();
        //pr.add(Projections.groupProperty(UserLocation.USERID));
        if (nw.getLongitude() <= ne.getLongitude()) {
            parameters.add(Restrictions.ge(UserLocation.LONGITUDE, nw.getLongitude()));
            parameters.add(Restrictions.le(UserLocation.LONGITUDE, ne.getLongitude()));
            return userLocationDao.findAll(parameters, orders, 0, 30, pr);
        } else {
            parameters.add(Restrictions.or(
                    Restrictions.ge(UserLocation.LONGITUDE, nw.getLongitude()),
                    Restrictions.le(UserLocation.LONGITUDE, ne.getLongitude())
            ));
            return userLocationDao.findAll(parameters, orders, 0, 30, pr);
        }

    }

    @Override
    @Transactional(value = "services")
    public User saveUserConfig(User user, UserConfig config) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String res = mapper.writeValueAsString(config);
            user.setConfig(res);
            userDao.update(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(value = "services")
    public UserConfig getUserConfig(User user) throws Exception {
        String config = user.getConfig();
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(config, UserConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(value = "services")
    public User getUser(Long userId) throws Exception {
        return userDao.find(userId);
    }

    @Override
    @Transactional(value = "services")
    public String createTempPassword(User u) throws Exception {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        int result = r.nextInt(high - low) + low;
        return Integer.toString(result);
    }

    @Override
    @Transactional(value = "services")
    public Token createMessagingToken(User u, Token.Type type, String token) throws Exception {
        Token existingToken = tokenDao.find(Restrictions.eq(Token.TOKEN, token));
        if (existingToken != null) {
            return existingToken;
        }
        Token t = new Token();
        t.setToken(token);
        t.setType(type);
        t.setUserId(u.getId());
        t.setCreated(new Date());
        Long tokenId = tokenDao.create(t);
        t.setId(tokenId);
        return t;
    }

    @Override
    @Transactional(value = "services")
    public Token getActiveMessagingToken(Long userId) throws Exception {
        List<Token> result = tokenDao.findAll(Arrays.asList(new Criterion[]{
                        Restrictions.eq(Token.USERID, userId),
                        Restrictions.or(Restrictions.eq(Token.TYPE, Token.Type.FIREBASE_ANDROID), Restrictions.eq(Token.TYPE, Token.Type.FIREBASE_IOS))
                }),
                Arrays.asList(new Order[]{
                        Order.desc(Token.CREATED)
                }),
                null,
                null);
        if (result.isEmpty()) return null;
        return result.get(0);
    }

    @Override
    @Transactional(value = "services")
    public void sendMail(String template, Map<String, Object> model, String subject, String to) throws Exception {
        String message = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, "utf-8", model);
        try {
            MimeMessage html = mailSender.createMimeMessage();
            html.setSubject(subject);
            MimeMessageHelper helper = new MimeMessageHelper(html, true);
            helper.setFrom(basicEmailMessage.getFrom());
            helper.setTo(to);
            helper.setText(message, true);
            mailSender.send(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
