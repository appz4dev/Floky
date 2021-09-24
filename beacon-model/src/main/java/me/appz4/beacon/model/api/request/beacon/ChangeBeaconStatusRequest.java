/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.model.BeaconStatus;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class ChangeBeaconStatusRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long beaconId;
/*    */   private BeaconStatus status;
/*    */   
/*    */   public Long getBeaconId()
/*    */   {
/* 16 */     return this.beaconId;
/*    */   }
/*    */   
/*    */   public void setBeaconId(Long beaconId) {
/* 20 */     this.beaconId = beaconId;
/*    */   }
/*    */   
/*    */   public BeaconStatus getStatus() {
/* 24 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(BeaconStatus status) {
/* 28 */     this.status = status;
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 33 */     ValidatorUtils.isNull(this.beaconId, "beaconId");
/* 34 */     ValidatorUtils.isNull(this.status, "status");
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\ChangeBeaconStatusRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */