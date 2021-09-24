/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*    */
/*    */ @javax.persistence.Entity
/*    */ @javax.persistence.Table(name="messaging_tokens")
/*    */ public class GcmToken implements java.io.Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -1303739435583671083L;
/*    */   public static final String TYPE = "type";
/*    */   public static final String USERID = "userId";
/*    */   @javax.persistence.Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name="id")
/*    */   @JsonIgnore
/*    */   private Long id;
/*    */   
/*    */   public static enum TokenTypes
/*    */   {
/* 23 */     ANDROID,  IOS;
/*    */     
/*    */ 
/*    */ 
/*    */     private TokenTypes() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @javax.persistence.Enumerated(javax.persistence.EnumType.STRING)
/*    */   @Column(name="type")
/*    */   private TokenTypes type;
/*    */   
/*    */ 
/*    */   @Column(name="token")
/*    */   private String token;
/*    */   
/*    */ 
/*    */   @Column(name="userId")
/*    */   private Long userId;
/*    */   
/*    */   @Column(name="created")
/*    */   private Date created;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 49 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 53 */     this.id = id;
/*    */   }
/*    */   
/*    */   public TokenTypes getType() {
/* 57 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(TokenTypes type) {
/* 61 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 65 */     return this.token;
/*    */   }
/*    */   
/*    */   public void setToken(String token) {
/* 69 */     this.token = token;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 73 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 77 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Date getCreated() {
/* 81 */     return this.created;
/*    */   }
/*    */   
/*    */   public void setCreated(Date created) {
/* 85 */     this.created = created;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 90 */     return "GcmToken [id=" + this.id + ", type=" + this.type + ", token=" + this.token + ", userId=" + this.userId + ", created=" + this.created + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\GcmToken.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */