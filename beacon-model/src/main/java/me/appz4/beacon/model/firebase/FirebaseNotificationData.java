package me.appz4.beacon.model.firebase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import me.appz4.beacon.model.model.Beacon;

public class FirebaseNotificationData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3794795869350685879L;

	public enum Type {
		FOUND_OWN_BEACON, SPOTTED_BEACON, FOUND_LOST_BEACON, SHARED_LOCATION, MESSAGE
	}
	
	private Type type;
	
	private String title;
	
	private String desc;
	
	private Long beaconId;
	
	private String beaconName;
	
	private String beaconDesc;
	
	private String beaconPhone;
	
	private String beaconFactoryId;

	private boolean hasBeaconLocation;
	
	private Long foundUserId;
	
	private Long messageThreadId;
	
	private Long firebaseMessageId;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getBeaconId() {
		return beaconId;
	}

	public void setBeaconId(Long beaconId) {
		this.beaconId = beaconId;
	}

	public String getBeaconName() {
		return beaconName;
	}

	public void setBeaconName(String beaconName) {
		this.beaconName = beaconName;
	}

	public String getBeaconDesc() {
		return beaconDesc;
	}

	public void setBeaconDesc(String beaconDesc) {
		this.beaconDesc = beaconDesc;
	}

	public String getBeaconPhone() {
		return beaconPhone;
	}

	public void setBeaconPhone(String beaconPhone) {
		this.beaconPhone = beaconPhone;
	}

	public String getBeaconFactoryId() {
		return beaconFactoryId;
	}

	public void setBeaconFactoryId(String beaconFactoryId) {
		this.beaconFactoryId = beaconFactoryId;
	}

	public boolean isHasBeaconLocation() {
		return hasBeaconLocation;
	}

	public void setHasBeaconLocation(boolean hasBeaconLocation) {
		this.hasBeaconLocation = hasBeaconLocation;
	}

	public Long getFoundUserId() {
		return foundUserId;
	}

	public void setFoundUserId(Long foundUserId) {
		this.foundUserId = foundUserId;
	}

	public Long getMessageThreadId() {
		return messageThreadId;
	}

	public void setMessageThreadId(Long messageThreadId) {
		this.messageThreadId = messageThreadId;
	}

	public Long getFirebaseMessageId() {
		return firebaseMessageId;
	}

	public void setFirebaseMessageId(Long firebaseMessageId) {
		this.firebaseMessageId = firebaseMessageId;
	}

	public Map<String, String> getData() {
		Map<String, String> data = new HashMap<>();
		data.put("title", title);
		data.put("desc", desc);
		data.put("type", type.name());
		if(beaconId != null) {
			data.put("beacon_id", Long.toString(beaconId));
		}
		data.put("beacon_name", beaconName);
		data.put("beacon_desc", beaconDesc);
		data.put("beacon_phone", beaconPhone);
		data.put("beacon_factory_id", beaconFactoryId);
		data.put("hasBeaconLocation", hasBeaconLocation ? "true" : "false");
		if(foundUserId != null) {
			data.put("found_user_id", Long.toString(foundUserId));
		}
		if(messageThreadId != null) {
			data.put("message_thread_id", Long.toString(messageThreadId));
		}
		if(firebaseMessageId != null) {
			data.put("firebase_message_id", Long.toString(firebaseMessageId));
		}
		return data;
	}
	
	public static FirebaseNotificationData fromData(Map<String, String> input) {
		FirebaseNotificationData data = new FirebaseNotificationData();
		data.setTitle(input.get("title"));
		data.setDesc(input.get("desc"));
		data.setType(Type.valueOf(input.get("type")));
		String bId = input.get("beacon_id");
		if(bId != null) {
			data.setBeaconId(Long.parseLong(bId));
		}
		data.setBeaconName(input.get("beacon_name"));
		data.setBeaconPhone(input.get("beacon_phone"));
		data.setBeaconDesc(input.get("beacon_desc"));
		data.setBeaconFactoryId(input.get("beacon_factory_id"));
		data.setHasBeaconLocation(false);
		String loc = input.get("hasBeaconLocation");
		if(loc != null && loc.equals("true")) {
			data.setHasBeaconLocation(true);
		}
		String foundUserId = input.get("found_user_id");
		if(foundUserId != null) {
			data.setFoundUserId(Long.parseLong(foundUserId));
		}
		String messageThreadId = input.get("message_thread_id");
		if(messageThreadId != null) {
			data.setMessageThreadId(Long.parseLong(messageThreadId));
		}
		String firebaseMessageId = input.get("firebase_message_id");
		if(firebaseMessageId != null) {
			data.setFirebaseMessageId(Long.parseLong(firebaseMessageId));
		}
		return data;
	}
	
	public Beacon getBeacon() {
		Beacon beacon = new Beacon();
		beacon.setId(getBeaconId());
		beacon.setName(getBeaconName());
		beacon.setDescription(getBeaconDesc());
		beacon.setPhone(getBeaconPhone());
		beacon.setFactoryId(getBeaconFactoryId());
		return beacon;
	}

	@Override
	public String toString() {
		return "FirebaseNotificationData [type=" + type + ", title=" + title + ", desc=" + desc + ", beaconId="
				+ beaconId + ", beaconName=" + beaconName + ", beaconDesc=" + beaconDesc + ", beaconPhone="
				+ beaconPhone + ", beaconFactoryId=" + beaconFactoryId + ", hasBeaconLocation=" + hasBeaconLocation
				+ ", foundUserId=" + foundUserId + ", messageThreadId=" + messageThreadId + ", firebaseMessageId="
				+ firebaseMessageId + "]";
	}
	
}
