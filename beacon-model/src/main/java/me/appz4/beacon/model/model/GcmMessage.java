/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import java.util.Date;
/*     */ import javax.persistence.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import me.appz4.beacon.model.gcm.GcmMessageTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="messaging_messages")
/*     */ public class GcmMessage
/*     */ {
/*     */   public static final String TYPE = "type";
/*     */   public static final String MESSAGE_TYPE = "messageType";
/*     */   public static final String USERID = "userId";
/*     */   public static final String BEACONID = "beaconId";
/*     */   public static final String CREATED = "created";
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   @JsonIgnore
/*     */   private Long id;
/*     */   @Column(name="eventId")
/*     */   private Long eventId;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(name="type")
/*     */   private GcmToken.TokenTypes type;
/*     */   @Enumerated(EnumType.STRING)
/*     */   @Column(name="messageType")
/*     */   private GcmMessageTypes messageType;
/*     */   @Column(name="data")
/*     */   private String data;
/*     */   @Column(name="userId")
/*     */   private Long userId;
/*     */   @Column(name="beaconId")
/*     */   private Long beaconId;
/*     */   @Column(name="created")
/*     */   private Date created;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  62 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getEventId() {
/*  66 */     return this.eventId;
/*     */   }
/*     */   
/*     */   public void setEventId(Long eventId) {
/*  70 */     this.eventId = eventId;
/*     */   }
/*     */   
/*     */   public GcmToken.TokenTypes getType() {
/*  74 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(GcmToken.TokenTypes type) {
/*  78 */     this.type = type;
/*     */   }
/*     */   
/*     */   public GcmMessageTypes getMessageType() {
/*  82 */     return this.messageType;
/*     */   }
/*     */   
/*     */   public void setMessageType(GcmMessageTypes messageType) {
/*  86 */     this.messageType = messageType;
/*     */   }
/*     */   
/*     */   public String getData() {
/*  90 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(String data) {
/*  94 */     this.data = data;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/*  98 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 102 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getBeaconId() {
/* 106 */     return this.beaconId;
/*     */   }
/*     */   
/*     */   public void setBeaconId(Long beaconId) {
/* 110 */     this.beaconId = beaconId;
/*     */   }
/*     */   
/*     */   public Date getCreated() {
/* 114 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(Date created) {
/* 118 */     this.created = created;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 123 */     return "GcmMessage [id=" + this.id + ", type=" + this.type + ", messageType=" + this.messageType + ", data=" + this.data + ", userId=" + this.userId + ", beaconId=" + this.beaconId + ", created=" + this.created + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\GcmMessage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */