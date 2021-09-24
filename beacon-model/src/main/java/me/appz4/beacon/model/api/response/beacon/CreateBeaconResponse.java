/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class CreateBeaconResponse extends ApiResponse
/*    */ {
/*    */   private Long beaconId;
/*    */   
/*    */   public Long getBeaconId() {
/* 10 */     return this.beaconId;
/*    */   }
/*    */   
/*    */   public void setBeaconId(Long beaconId) {
/* 14 */     this.beaconId = beaconId;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return "CreateBeaconResponse [beaconId=" + this.beaconId + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\CreateBeaconResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */