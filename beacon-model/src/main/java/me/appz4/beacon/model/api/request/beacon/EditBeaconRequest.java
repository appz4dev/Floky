/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EditBeaconRequest
/*    */   extends ApiRequestWithToken
/*    */ {
/*    */   private Long beaconId;
/*    */   private String name;
/*    */   private String desc;
/*    */   private String type;
/*    */   private String iconType;
/*    */   private String phone;
/*    */   
/*    */   public Long getBeaconId()
/*    */   {
/* 20 */     return this.beaconId;
/*    */   }
/*    */   
/*    */   public void setBeaconId(Long beaconId) {
/* 24 */     this.beaconId = beaconId;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 28 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 32 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getDesc() {
/* 36 */     return this.desc;
/*    */   }
/*    */   
/*    */   public void setDesc(String desc) {
/* 40 */     this.desc = desc;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 44 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 48 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getIconType() {
/* 52 */     return this.iconType;
/*    */   }
/*    */   
/*    */   public void setIconType(String iconType) {
/* 56 */     this.iconType = iconType;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 60 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 64 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 69 */     return "EditBeaconRequest [beaconId=" + this.beaconId + ", name=" + this.name + ", desc=" + this.desc + ", type=" + this.type + ", iconType=" + this.iconType + ", phone=" + this.phone + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\EditBeaconRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */