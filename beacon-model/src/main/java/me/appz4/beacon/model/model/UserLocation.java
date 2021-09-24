/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.*;
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="user_locations")
/*    */ public class UserLocation
/*    */ {
/*    */   public static final String USERID = "userId";
/*    */   public static final String CREATED = "created";
		   public static final String LATITUDE = "latitude";
		   public static final String LONGITUDE = "longitude";	   
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name="id")
/*    */   private Long id;
/*    */   @Column(name="userId")
/*    */   private Long userId;
/*    */   @Column(name="latitude")
/*    */   private Double latitude;
/*    */   @Column(name="longitude")
/*    */   private Double longitude;
/*    */   @Column(name="created")
/*    */   private Date created;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 44 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 48 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Double getLatitude() {
/* 52 */     return this.latitude;
/*    */   }
/*    */   
/*    */   public void setLatitude(Double latitude) {
/* 56 */     this.latitude = latitude;
/*    */   }
/*    */   
/*    */   public Double getLongitude() {
/* 60 */     return this.longitude;
/*    */   }
/*    */   
/*    */   public void setLongitude(Double longitude) {
/* 64 */     this.longitude = longitude;
/*    */   }
/*    */   
/*    */   public Date getCreated() {
/* 68 */     return this.created;
/*    */   }
/*    */   
/*    */   public void setCreated(Date created) {
/* 72 */     this.created = created;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 77 */     return "UserLocation [id=" + this.id + ", userId=" + this.userId + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", created=" + this.created + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\UserLocation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */