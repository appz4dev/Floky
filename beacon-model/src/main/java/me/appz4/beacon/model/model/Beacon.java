/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="beacons")
/*     */ public class Beacon
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -9082578783515377585L;
/*     */   public static final String ID = "id";
/*     */   public static final String USERID = "userId";
/*     */   public static final String FACTORYID = "factoryId";
/*     */   public static final String NAME = "name";
/*     */   public static final String STATUSMODIFIED = "statusModified";
/*     */   public static final String STATUS = "status";
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   private Long id;
/*     */   @Column(name="factoryId")
/*     */   private String factoryId;
/*     */   @Column(name="userId")
/*     */   @JsonIgnore
/*     */   private Long userId;
/*     */   @Column(name="created")
/*     */   private Date created;
/*     */   @Column(name="modified")
/*     */   @JsonIgnore
/*     */   private Date modified;
/*     */   @Column(name="statusModified")
/*     */   @JsonIgnore
/*     */   private Date statusModified;
/*     */   @Column(name="name")
/*     */   private String name;
/*     */   @Column(name="description")
/*     */   private String description;
/*     */   @Column(name="type")
/*     */   private String type;
/*     */   @Column(name="iconType")
/*     */   private String iconType;
/*     */   @Column(name="phone")
/*     */   private String phone;
/*     */   @Column(name="status")
/*     */   private BeaconStatus status;
/*     */   @Transient
/*     */   private Position location;
/*     */   @Column(name="manufacturerId")
/*     */   private Long manufacturerId;
/*     */   @Transient
/*     */   private BeaconManufacturer beaconType;
/*     */   @Transient
/*     */   private User user;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  82 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  86 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getFactoryId() {
/*  90 */     return this.factoryId;
/*     */   }
/*     */   
/*     */   public void setFactoryId(String factoryId) {
/*  94 */     this.factoryId = factoryId;
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
/*     */   public Date getCreated() {
/* 106 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(Date created) {
/* 110 */     this.created = created;
/*     */   }
/*     */   
/*     */   public Date getModified() {
/* 114 */     return this.modified;
/*     */   }
/*     */   
/*     */   public void setModified(Date modified) {
/* 118 */     this.modified = modified;
/*     */   }
/*     */   
/*     */   public Date getStatusModified() {
/* 122 */     return this.statusModified;
/*     */   }
/*     */   
/*     */   public void setStatusModified(Date statusModified) {
/* 126 */     this.statusModified = statusModified;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 130 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 134 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 138 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 142 */     this.description = description;
/*     */   }
/*     */   
/*     */   public String getType() {
/* 146 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 150 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getIconType() {
/* 154 */     return this.iconType;
/*     */   }
/*     */   
/*     */   public void setIconType(String iconType) {
/* 158 */     this.iconType = iconType;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/* 162 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/* 166 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public BeaconStatus getStatus() {
/* 170 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(BeaconStatus status) {
/* 174 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Position getLocation() {
/* 178 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(Position location) {
/* 182 */     this.location = location;
/*     */   }
/*     */   
/*     */   public Long getManufacturerId() {
/* 186 */     return this.manufacturerId;
/*     */   }
/*     */   
/*     */   public void setManufacturerId(Long manufacturerId) {
/* 190 */     this.manufacturerId = manufacturerId;
/*     */   }
/*     */   
/*     */   public BeaconManufacturer getBeaconType() {
/* 194 */     return this.beaconType;
/*     */   }
/*     */   
/*     */   public void setBeaconType(BeaconManufacturer beaconType) {
/* 198 */     this.beaconType = beaconType;
/*     */   }
/*     */   
/*     */   public User getUser() {
/* 202 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(User user) {
/* 206 */     this.user = user;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 211 */     return "Beacon [id=" + this.id + ", factoryId=" + this.factoryId + ", userId=" + this.userId + ", created=" + this.created + ", modified=" + this.modified + ", statusModified=" + this.statusModified + ", name=" + this.name + ", description=" + this.description + ", type=" + this.type + ", iconType=" + this.iconType + ", phone=" + this.phone + ", status=" + this.status + ", location=" + this.location + ", manufacturerId=" + this.manufacturerId + ", beaconType=" + this.beaconType + ", user=" + this.user + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\Beacon.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */