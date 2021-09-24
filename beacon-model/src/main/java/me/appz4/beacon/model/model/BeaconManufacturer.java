/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
import javax.persistence.GenerationType;

/*    */
/*    */ @javax.persistence.Entity
/*    */ @javax.persistence.Table(name="beacon_types")
/*    */ public class BeaconManufacturer
/*    */ {
/*    */   public static final String ID = "id";
/*    */   public static final String NAME = "name";
/*    */   public static final String STATUS = "status";
/*    */   @javax.persistence.Id
/*    */   @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name="id")
/*    */   private Long id;
/*    */   
/*    */   public static enum StatusTypes
/*    */   {
/* 20 */     ACTIVE,  REMOVED;
/*    */     
/*    */ 
/*    */     private StatusTypes() {}
/*    */   }
/*    */   
/*    */ 
/*    */   @Column(name="name")
/*    */   private String name;
/*    */   
/*    */   @Column(name="type")
/*    */   private String type;
/*    */   
/*    */   @Column(name="configuration")
/*    */   private String configuration;
/*    */   
/*    */   @Column(name="created")
/*    */   private Date created;
/*    */   
/*    */   @Column(name="status")
/*    */   private StatusTypes status;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 44 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 48 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 52 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 56 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 60 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 64 */     this.type = type;
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
/*    */   public StatusTypes getStatus() {
/* 76 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(StatusTypes status) {
/* 80 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getConfiguration() {
/* 84 */     return this.configuration;
/*    */   }
/*    */   
/*    */   public void setConfiguration(String configuration) {
/* 88 */     this.configuration = configuration;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 93 */     return "BeaconManufacturer [id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", created=" + this.created + ", status=" + this.status + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\BeaconManufacturer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */