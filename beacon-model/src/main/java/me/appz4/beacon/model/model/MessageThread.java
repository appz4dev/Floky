/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.*;
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
/*     */ @Table(name="message_threads")
/*     */ public class MessageThread
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 6547499841401193150L;
/*     */   public static final String ID = "id";
/*     */   public static final String BEACONID = "beaconId";
/*     */   public static final String USERID = "userId";
/*     */   public static final String RECEPIENTID = "recepientId";
/*     */   public static final String MODIFIED = "modified";
/*     */   public static final String STATUS = "status";
/*     */   public static final String CREATED = "created";
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   private Long id;
/*     */   @Column(name="beaconId")
/*     */   private Long beaconId;
/*     */   @Column(name="userId")
/*     */   @JsonIgnore
/*     */   private Long userId;
/*     */   @Transient
/*     */   private User fromUser;
/*     */   @Column(name="recepientId")
/*     */   private Long recepientId;
/*     */   @Transient
/*     */   private User toUser;
/*     */   @Column(name="created")
/*     */   private Date created;
/*     */   @Column(name="modified")
/*     */   private Date modified;
/*     */   @Column(name="unread")
/*     */   private Integer unread;
/*     */   @Column(name="unreadRecipient")
/*     */   private Integer unreadRecipient;
/*     */   @Column(name="message")
/*     */   private Integer message;
/*     */   @Column(name="status")
/*     */   private Integer status;
/*  70 */   private transient List<Message> messages = new ArrayList();
/*     */   private transient Beacon beacon;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getBeaconId() {
/*  83 */     return this.beaconId;
/*     */   }
/*     */   
/*     */   public void setBeaconId(Long beaconId) {
/*  87 */     this.beaconId = beaconId;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/*  91 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  95 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getRecepientId() {
/*  99 */     return this.recepientId;
/*     */   }
/*     */   
/*     */   public void setRecepientId(Long recepientId) {
/* 103 */     this.recepientId = recepientId;
/*     */   }
/*     */   
/*     */   public Date getCreated() {
/* 107 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(Date created) {
/* 111 */     this.created = created;
/*     */   }
/*     */   
/*     */   public Date getModified() {
/* 115 */     return this.modified;
/*     */   }
/*     */   
/*     */   public void setModified(Date modified) {
/* 119 */     this.modified = modified;
/*     */   }
/*     */   
/*     */   public Integer getUnread() {
/* 123 */     return this.unread;
/*     */   }
/*     */   
/*     */   public void setUnread(Integer unread) {
/* 127 */     this.unread = unread;
/*     */   }
/*     */   
/*     */   public Integer getUnreadRecipient() {
/* 131 */     return this.unreadRecipient;
/*     */   }
/*     */   
/*     */   public void setUnreadRecipient(Integer unreadRecipient) {
/* 135 */     this.unreadRecipient = unreadRecipient;
/*     */   }
/*     */   
/*     */   public Integer getMessage() {
/* 139 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(Integer message) {
/* 143 */     this.message = message;
/*     */   }
/*     */   
/*     */   public static long getSerialversionuid() {
/* 147 */     return 6547499841401193150L;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 151 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 155 */     this.status = status;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public List<Message> getMessages() {
/* 160 */     return this.messages;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public void setMessages(List<Message> messages) {
/* 165 */     this.messages = messages;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public Beacon getBeacon() {
/* 170 */     return this.beacon;
/*     */   }
/*     */   
/*     */   @Transient
/*     */   public void setBeacon(Beacon beacon) {
/* 175 */     this.beacon = beacon;
/*     */   }
/*     */   
/*     */   public User getFromUser() {
/* 179 */     return this.fromUser;
/*     */   }
/*     */   
/*     */   public void setFromUser(User fromUser) {
/* 183 */     this.fromUser = fromUser;
/*     */   }
/*     */   
/*     */   public User getToUser() {
/* 187 */     return this.toUser;
/*     */   }
/*     */   
/*     */   public void setToUser(User toUser) {
/* 191 */     this.toUser = toUser;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 196 */     return "MessageThread [id=" + this.id + ", userId=" + this.userId + ", recepientId=" + this.recepientId + ", created=" + this.created + ", modified=" + this.modified + ", unread=" + this.unread + ", message=" + this.message + ", status=" + this.status + ", messages=" + this.messages + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\MessageThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */