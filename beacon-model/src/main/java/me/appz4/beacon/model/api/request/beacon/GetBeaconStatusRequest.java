/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class GetBeaconStatusRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private String factoryId;
/*    */   
/*    */   public String getFactoryId()
/*    */   {
/* 14 */     return this.factoryId;
/*    */   }
/*    */   
/*    */   public void setFactoryId(String factoryId) {
/* 18 */     this.factoryId = factoryId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 23 */     return "GetBeaconStatusRequest [factoryId=" + this.factoryId + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 28 */     if (!ValidatorUtils.hasText(this.factoryId)) throw new ValidationException(me.appz4.beacon.model.exception.Errors.ERROR_PARAMETER, new String[] { "factoryId" });
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\GetBeaconStatusRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */