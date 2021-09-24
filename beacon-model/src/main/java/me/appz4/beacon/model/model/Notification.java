package me.appz4.beacon.model.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.appz4.beacon.model.firebase.FirebaseNotificationData;

@Entity
@Table(name="notifications")
public class Notification implements java.io.Serializable {

	private static final long serialVersionUID = 7382408602425003297L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="sender_id")
	private Long senderId;
	
	@Column(name="recipient_id")
	private Long recipientId;
	
	@Column(name="beacon_id")
	private Long beaconId;
	
	@Column(name="type")
	private FirebaseNotificationData.Type type;
	
	@Column(name="created")
	@JsonIgnore
	private Date created;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public Long getBeaconId() {
		return beaconId;
	}

	public void setBeaconId(Long beaconId) {
		this.beaconId = beaconId;
	}

	public FirebaseNotificationData.Type getType() {
		return type;
	}

	public void setType(FirebaseNotificationData.Type type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", senderId=" + senderId + ", recipientId=" + recipientId + ", beaconId="
				+ beaconId + ", type=" + type + ", created=" + created + "]";
	}
	
}
