/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import javax.persistence.Column;
import javax.persistence.GenerationType;

/*     */
/*     */ @javax.persistence.Entity
/*     */ @javax.persistence.Table(name="messages")
/*     */ public class Message implements java.io.Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1587520006740217190L;
/*     */   public static final String ID = "id";
/*     */   public static final String THREADID = "threadId";
/*     */   public static final String USERID = "userId";
/*     */   public static final String RECIPIENTID = "recipientId";
/*     */   public static final String CREATED = "created";
/*     */   public static final String STATUS = "status";
/*     */   public static final String STATUSRECIPIENT = "statusRecipient";
/*     */   
/*     */   public static enum MessageStatuses {
/*  19 */     UNREAD,  READ;
/*     */     
/*     */ 
/*     */ 
/*     */     private MessageStatuses() {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @javax.persistence.Id
/*     */   @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   private Long id;
/*     */   
/*     */ 
/*     */   @Column(name="threadId")
/*     */   @com.fasterxml.jackson.annotation.JsonIgnore
/*     */   private Long threadId;
/*     */   
/*     */ 
/*     */   @Column(name="userId")
/*     */   private Long userId;
/*     */   
/*     */ 
/*     */   @Column(name="recipientId")
/*     */   private Long recipientId;
/*     */   
/*     */   @Column(name="created")
/*     */   private java.util.Date created;
/*     */   
/*     */   @Column(name="modified")
/*     */   private java.util.Date modified;
/*     */   
/*     */   @Column(name="message")
/*     */   private String message;
/*     */   
/*     */   @Column(name="status")
/*     */   private MessageStatuses status;
/*     */   
/*     */   @Column(name="statusRecipient")
/*     */   private MessageStatuses statusRecipient;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getThreadId() {
/*  71 */     return this.threadId;
/*     */   }
/*     */   
/*     */   public void setThreadId(Long threadId) {
/*  75 */     this.threadId = threadId;
/*     */   }
/*     */   
/*     */   public java.util.Date getCreated() {
/*  79 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(java.util.Date created) {
/*  83 */     this.created = created;
/*     */   }
/*     */   
/*     */   public java.util.Date getModified() {
/*  87 */     return this.modified;
/*     */   }
/*     */   
/*     */   public void setModified(java.util.Date modified) {
/*  91 */     this.modified = modified;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  95 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  99 */     this.message = message;
/*     */   }
/*     */   
/*     */   public MessageStatuses getStatus() {
/* 103 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(MessageStatuses status) {
/* 107 */     this.status = status;
/*     */   }
/*     */   
/*     */   public static long getSerialversionuid() {
/* 111 */     return 1587520006740217190L;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/* 115 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/* 119 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public MessageStatuses getStatusRecipient() {
/* 123 */     return this.statusRecipient;
/*     */   }
/*     */   
/*     */   public void setStatusRecipient(MessageStatuses statusRecipient) {
/* 127 */     this.statusRecipient = statusRecipient;
/*     */   }
/*     */   
/*     */   public Long getRecipientId() {
/* 131 */     return this.recipientId;
/*     */   }
/*     */   
/*     */   public void setRecipientId(Long recipientId) {
/* 135 */     this.recipientId = recipientId;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 140 */     return "Message [id=" + this.id + ", threadId=" + this.threadId + ", userId=" + this.userId + ", recipientId=" + this.recipientId + ", created=" + this.created + ", modified=" + this.modified + ", message=" + this.message + ", status=" + this.status + ", statusRecipient=" + this.statusRecipient + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\Message.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */