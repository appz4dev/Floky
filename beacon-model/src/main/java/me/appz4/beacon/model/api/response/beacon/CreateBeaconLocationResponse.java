/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class CreateBeaconLocationResponse extends ApiResponse
/*    */ {
/*    */   private Long locationId;
/*    */   
/*    */   public Long getLocationId() {
/* 10 */     return this.locationId;
/*    */   }
/*    */   
/*    */   public void setLocationId(Long locationId) {
/* 14 */     this.locationId = locationId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 19 */     return "CreateBeaconLocationResponse [locationId=" + this.locationId + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\CreateBeaconLocationResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */