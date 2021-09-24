/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.model.Position;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class FoundLostBeaconRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private String factoryId;
/*    */   private Position position;
/*    */   
/*    */   public String getFactoryId()
/*    */   {
/* 17 */     return this.factoryId;
/*    */   }
/*    */   
/*    */   public void setFactoryId(String factoryId) {
/* 21 */     this.factoryId = factoryId;
/*    */   }
/*    */   
/*    */   public Position getPosition() {
/* 25 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Position position) {
/* 29 */     this.position = position;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 34 */     return "FoundLostBeaconRequest [factoryId=" + this.factoryId + ", position=" + this.position + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 39 */     if (!ValidatorUtils.hasText(this.factoryId)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "factoryId" });
/* 40 */     ValidatorUtils.isNull(this.position, "position");
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\FoundLostBeaconRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */