/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*     */
/*     */ @javax.persistence.Entity
/*     */ @javax.persistence.Table(name="users")
/*     */ public class User implements java.io.Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7860510222335620614L;
/*     */   public static final String ID = "id";
/*     */   public static final String EMAIL = "email";
/*     */   public static final String PASSWORD = "password";
/*     */   
/*     */   public static enum Statuses
/*     */   {
/*  19 */     ACTIVE,  INACTIVE;
/*     */     
/*     */ 
/*     */     private Statuses() {}
/*     */   }
/*     */   
/*     */ 
/*     */   public static final String USERNAME = "username";
/*     */   
/*     */   public static final String STATUS = "status";
/*     */   
/*     */   @javax.persistence.Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   private Long id;
/*     */   
/*     */   @Column(name="email")
/*     */   private String email;
/*     */   
/*     */   @Column(name="username")
/*     */   private String username;
/*     */   
/*     */   @Column(name="fullname")
/*     */   private String fullname;
/*     */   
/*     */   @Column(name="password")
/*     */   @JsonIgnore
/*     */   private String password;
/*     */   
/*     */   @Column(name="phone")
/*     */   private String phone;
/*     */   
/*     */   @Column(name="icon")
/*     */   private String icon;
/*     */   
/*     */   @Column(name="created")
/*     */   @JsonIgnore
/*     */   private Date created;
/*     */   
/*     */   @Column(name="modified")
/*     */   @JsonIgnore
/*     */   private Date modified;
/*     */   
/*     */   @Column(name="privacy")
/*     */   @JsonIgnore
/*     */   private Integer privacy;
/*     */   
/*     */   @Column(name="verified")
/*     */   private Integer verified;
/*     */   
/*     */   @Column(name="config")
/*     */   private String config;
/*     */   
/*     */   @Column(name="status")
/*     */   @JsonIgnore
/*     */   private Statuses status;
/*     */   public Long getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  81 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/*  85 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/*  89 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  93 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  97 */     this.username = username;
/*     */   }
/*     */   
/*     */   public String getFullname() {
/* 101 */     return this.fullname;
/*     */   }
/*     */   
/*     */   public void setFullname(String fullname) {
/* 105 */     this.fullname = fullname;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 109 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 113 */     this.password = password;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 117 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 121 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getIcon() {
/* 125 */     return this.icon;
/*     */   }
/*     */   
/*     */   public void setIcon(String icon) {
/* 129 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public Date getCreated() {
/* 133 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(Date created) {
/* 137 */     this.created = created;
/*     */   }
/*     */   
/*     */   public Date getModified() {
/* 141 */     return this.modified;
/*     */   }
/*     */   
/*     */   public void setModified(Date modified) {
/* 145 */     this.modified = modified;
/*     */   }
/*     */   
/*     */   public Statuses getStatus() {
/* 149 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Statuses status) {
/* 153 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Integer getPrivacy() {
/* 157 */     return this.privacy;
/*     */   }
/*     */   
/*     */   public void setPrivacy(Integer privacy) {
/* 161 */     this.privacy = privacy;
/*     */   }
/*     */   
/*     */   public String getConfig() {
/* 165 */     return this.config;
/*     */   }
/*     */   
/*     */   public void setConfig(String config) {
/* 169 */     this.config = config;
/*     */   }
/*     */   
/*     */   public Integer getVerified() {
/* 173 */     return this.verified;
/*     */   }
/*     */   
/*     */   public void setVerified(Integer verified) {
/* 177 */     this.verified = verified;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 182 */     return "User [id=" + this.id + ", email=" + this.email + ", username=" + this.username + ", fullname=" + this.fullname + ", password=" + this.password + ", phone=" + this.phone + ", icon=" + this.icon + ", created=" + this.created + ", modified=" + this.modified + ", privacy=" + this.privacy + ", verified=" + this.verified + ", config=" + this.config + ", status=" + this.status + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */