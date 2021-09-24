/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*    */
/*    */ @javax.persistence.Entity
/*    */ @javax.persistence.Table(name="tokens")
/*    */ public class Token implements java.io.Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5796937049535291833L;
/*    */   public static final String TOKEN = "token";
/*    */   public static final String TYPE = "type";
/*    */   public static final String USERID = "userId";
		   public static final String CREATED = "created";
/*    */   
/*    */   public static enum Type
/*    */   {
/* 19 */     LOGIN,  PASSWORD,  VERIFICATION, FIREBASE_ANDROID, FIREBASE_IOS;
/*    */     
/*    */ 
/*    */ 
/*    */     private Type() {}
/*    */   }
/*    */   
/*    */ 
/*    */   @javax.persistence.Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name="id")
/*    */   @JsonIgnore
/*    */   private Long id;
/*    */   
/*    */   @Column(name="token")
/*    */   private String token;
/*    */   
/*    */   @Column(name="userId")
/*    */   @JsonIgnore
/*    */   private Long userId;
/*    */   
/*    */   @Column(name="type")
/*    */   @JsonIgnore
/*    */   private Type type;
/*    */   
/*    */   @Column(name="created")
/*    */   @JsonIgnore
/*    */   private Date created;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 50 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 54 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 58 */     return this.token;
/*    */   }
/*    */   
/*    */   public void setToken(String token) {
/* 62 */     this.token = token;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 66 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 70 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Type getType() {
/* 74 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(Type type) {
/* 78 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Date getCreated() {
/* 82 */     return this.created;
/*    */   }
/*    */   
/*    */   public void setCreated(Date created) {
/* 86 */     this.created = created;
/*    */   }
/*    */   
/*    */   public static long getSerialversionuid() {
/* 90 */     return 5796937049535291833L;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 95 */     return "Token [id=" + this.id + ", token=" + this.token + ", userId=" + this.userId + ", type=" + this.type + ", created=" + this.created + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\Token.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */