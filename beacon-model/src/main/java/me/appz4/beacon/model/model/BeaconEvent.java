/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import javax.persistence.Column;
import javax.persistence.GenerationType;

/*    */
/*    */ @javax.persistence.Entity
/*    */ @javax.persistence.Table(name="beacon_events")
/*    */ public class BeaconEvent implements java.io.Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3345895087311816602L;
/*    */   public static final String ID = "id";
/*    */   public static final String BEACONID = "beaconId";
/*    */   public static final String USERID = "userId";
/*    */   public static final String TYPE = "type";
/*    */   public static final String CREATED = "created";
/*    */   
/*    */   public static enum Types {
/* 17 */     LOST,  FOUND;
/*    */     
/*    */ 
/*    */ 
/*    */     private Types() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @javax.persistence.Id
/*    */   @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name="id")
/*    */   private Long id;
/*    */   
/*    */ 
/*    */   @Column(name="beaconId")
/*    */   private Long beaconId;
/*    */   
/*    */   @Column(name="userId")
/*    */   private Long userId;
/*    */   
/*    */   @Column(name="created")
/*    */   private java.util.Date created;
/*    */   
/*    */   @Column(name="type")
/*    */   private Types type;
/*    */   
/*    */   @Column(name="messaged")
/*    */   private Integer messaged;
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
/*    */   public Long getBeaconId() {
/* 57 */     return this.beaconId;
/*    */   }
/*    */   
/*    */   public void setBeaconId(Long beaconId) {
/* 61 */     this.beaconId = beaconId;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 65 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 69 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public java.util.Date getCreated() {
/* 73 */     return this.created;
/*    */   }
/*    */   
/*    */   public void setCreated(java.util.Date created) {
/* 77 */     this.created = created;
/*    */   }
/*    */   
/*    */   public Types getType() {
/* 81 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(Types type) {
/* 85 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Integer getMessaged() {
/* 89 */     return this.messaged;
/*    */   }
/*    */   
/*    */   public void setMessaged(Integer messaged) {
/* 93 */     this.messaged = messaged;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 98 */     return "BeaconEvent [id=" + this.id + ", beaconId=" + this.beaconId + ", userId=" + this.userId + ", created=" + this.created + ", type=" + this.type + ", messaged=" + this.messaged + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\BeaconEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */