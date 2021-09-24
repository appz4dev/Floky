package me.appz4.beacon.service;

import java.util.List;
import java.util.Map;

import me.appz4.beacon.model.model.Position;
import me.appz4.beacon.model.model.Token;
import me.appz4.beacon.model.model.Token.Type;
import me.appz4.beacon.model.model.User;
import me.appz4.beacon.model.model.UserConfig;
import me.appz4.beacon.model.model.UserLocation;
import me.appz4.beacon.model.model.UserWithToken;

public interface UserService {
	
	User createUser(String email, String username, String password, String fullname, String phone, String icon, Integer privacy) throws Exception;

	UserWithToken loginUser(String email, String password) throws Exception;
	
	User checkUserEmail(String email) throws Exception;
	
	boolean checkUserName(String username) throws Exception;

	UserWithToken loginUserByToken(String token) throws Exception;
	
	void logoutUserByToken(String token) throws Exception;
	
	User isUserActive(Long userId) throws Exception;
	
	void deleteUser(Long userId) throws Exception;

	List<UserLocation> getNearUsers() throws Exception;

	UserLocation createUserLocation(Long userId, Position pos) throws Exception;

	String createTempPassword(User u) throws Exception;
	
	List<UserLocation> getNearUsers(Position ne, Position sw, List<Long> userIds) throws Exception;

	User getUser(Long userId) throws Exception;

	User saveUserConfig(User user, UserConfig config) throws Exception;

	UserConfig getUserConfig(User user) throws Exception;

	void updateUser(User user, String newPassword) throws Exception;

	Token createMessagingToken(User u, Type type, String token) throws Exception;

	Token getActiveMessagingToken(Long userId) throws Exception;

	void sendMail(String template, Map<String, Object> model, String subject, String to) throws Exception;
	
}
