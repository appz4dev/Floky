package me.appz4.beacon.firebase;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.filter.LoggingFilter;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.appz4.beacon.dao.NotificationDao;
import me.appz4.beacon.model.exception.Errors;
import me.appz4.beacon.model.exception.ServiceException;
import me.appz4.beacon.model.firebase.FirebaseNotificationData;
import me.appz4.beacon.model.firebase.FirebaseNotificationData.Type;
import me.appz4.beacon.model.model.Beacon;
import me.appz4.beacon.model.model.MessageThread;
import me.appz4.beacon.model.model.Notification;

public class FirebaseService {
	
	@Autowired
	private NotificationDao notificationDao;
	
	private ObjectMapper map = new ObjectMapper();
	
	@Transactional("services")
	public Notification sendNotification(Long fromUser, Long toUser, Long beaconId, String to, FirebaseNotificationData data) throws Exception {
		Notification existingNotification = findNotification(fromUser, toUser, beaconId);
		if(existingNotification != null) {
			if(!data.getType().equals(FirebaseNotificationData.Type.FOUND_OWN_BEACON)) {
				return existingNotification;
			}
		}
		FirebaseNotification not = new FirebaseNotification();
		not.setTo(to);
		Notification saved = createNotification(fromUser, toUser, data.getBeaconId(), data.getType());
		Long notificationId = notificationDao.create(saved);
		saved.setId(notificationId);
		data.setFirebaseMessageId(notificationId);
		Map<String, String> input = data.getData();
		not.setData(input);
		Client client = ClientBuilder.newBuilder().build();
		client.register(new LoggingFilter());
		Response response = client.target("https://fcm.googleapis.com/fcm/send")
				.request()
				.header("Authorization", "key=AAAAXMmTKDE:APA91bEbEeZFgudBqKWltLNXTollMrSLLT6QdwoOvSndyfSwz2kF6GD5Xhgm_nX3D2lmGoUq-Fi5WYrxlrb8-40umOLdNpX_lbRt6lroXBSuf9jejBWTh_VW6jBO_uZ39UnmdRV-pL45")
				.header("Content-Type", "application/json")
				.post(Entity.entity(not, MediaType.APPLICATION_JSON));
		String stringResponse = response.readEntity(String.class);
		try {
			FirebaseResponse fbResponse = map.readValue(stringResponse, FirebaseResponse.class);
			if(fbResponse.getSuccess() == 1) {
				return saved;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FirebaseNotificationData foundOwnBeacon(ApplicationContext context, Locale locale, Beacon beacon) {
		FirebaseNotificationData input = new FirebaseNotificationData();
		input.setType(Type.FOUND_OWN_BEACON);
		input.setTitle(context.getMessage("found_own_beacon_title", null, locale));
		input.setDesc(context.getMessage("found_own_beacon_desc", null, locale));
		setBeaconData(input, beacon);
		return input;
	}
	
	public FirebaseNotificationData spottedBeacon(ApplicationContext context, Locale locale, Beacon beacon, MessageThread thread) {
		FirebaseNotificationData input = new FirebaseNotificationData();
		input.setType(Type.SPOTTED_BEACON);
		input.setTitle(context.getMessage("spotted_beacon_title", null, locale));
		input.setDesc(context.getMessage("spotted_beacon_desc", null, locale));
		setBeaconData(input, beacon);
		if(thread != null) {
			input.setMessageThreadId(thread.getId());
		}
		return input;
	}
	
	public FirebaseNotificationData foundLostBeacon(ApplicationContext context, Locale locale, Beacon beacon, MessageThread thread) {
		FirebaseNotificationData input = new FirebaseNotificationData();
		input.setType(Type.FOUND_LOST_BEACON);
		input.setTitle(context.getMessage("found_lost_beacon_title", null, locale));
		input.setDesc(context.getMessage("found_lost_beacon_desc", null, locale));
		setBeaconData(input, beacon);
		if(thread != null) {
			input.setMessageThreadId(thread.getId());
		}
		return input;
	}
	
	public FirebaseNotificationData newMessage(ApplicationContext context, Locale locale, String userName, MessageThread thread) {
		FirebaseNotificationData input = new FirebaseNotificationData();
		input.setType(Type.MESSAGE);
		input.setTitle(context.getMessage("new_message_title", null, locale));
		input.setDesc(context.getMessage("new_message_desc", new String[] {userName}, locale));
		if(thread != null) {
			input.setMessageThreadId(thread.getId());
		}
		return input;
	}
	
	private void setBeaconData(FirebaseNotificationData input, Beacon beacon) {
		if(input == null || beacon == null) return;
		input.setBeaconId(beacon.getId());
		input.setBeaconName(beacon.getName());
		input.setBeaconDesc(beacon.getDescription());
		input.setBeaconPhone(beacon.getPhone());
		input.setBeaconFactoryId(beacon.getFactoryId());
	}
	
	private Notification createNotification(Long senderId, Long recipientId, Long beaconId, Type type) {
		Notification not = new Notification();
		not.setSenderId(senderId);
		not.setRecipientId(recipientId);
		not.setType(type);
		not.setBeaconId(beaconId);
		not.setCreated(new Date());
		return not;
	}
	
	@Transactional("services")
	private Notification findNotification(Long fromUser, Long toUser, Long beaconId) throws Exception {
		if(beaconId == null) return null;
		Notification item = notificationDao.find(
				Restrictions.eq("senderId", fromUser), 
				Restrictions.eq("recipientId", toUser),
				Restrictions.eq("beaconId", beaconId)
			);
		return item;
	}			
	
	@Transactional("services")
	public Notification getNotification(Long userId, Long notificationId) throws Exception {
		Notification item = notificationDao.find(
			Restrictions.eq("id", notificationId), 
			Restrictions.or(
				Restrictions.eq("senderId", userId), 
				Restrictions.eq("recipientId", userId)
			)
		);
		if(item == null) {
			throw new ServiceException(Errors.ERROR_ITEM_NOT_FOUND);
		}
		return item;
	}
	
}
