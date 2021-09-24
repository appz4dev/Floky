/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.BeaconStatus;
/*    */ 
/*    */ public class GetBeaconStatusResponse extends ApiResponse
/*    */ {
/*    */   private BeaconStatus status;
/*    */   private Long userId;
/*    */   
/*    */   public BeaconStatus getStatus()
/*    */   {
/* 13 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(BeaconStatus status) {
/* 17 */     this.status = status;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 21 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 25 */     this.userId = userId;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 31 */     return "GetBeaconStatusResponse [status=" + this.status + ", userId=" + this.userId + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetBeaconStatusResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */