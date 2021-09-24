/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class DeleteBeaconRequest extends ApiRequestWithToken implements me.appz4.beacon.model.validator.IRequestValidator
/*    */ {
/*    */   private Long beaconId;
/*    */   
/*    */   public Long getBeaconId()
/*    */   {
/* 13 */     return this.beaconId;
/*    */   }
/*    */   
/*    */   public void setBeaconId(Long beaconId) {
/* 17 */     this.beaconId = beaconId;
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 22 */     ValidatorUtils.isNull(this.beaconId, "beaconId");
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\DeleteBeaconRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */