/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.model.Position;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class AddBeaconLocationRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long eventId;
/*    */   private Position position;
/*    */   
/*    */   public Long getEventId()
/*    */   {
/* 16 */     return this.eventId;
/*    */   }
/*    */   
/*    */   public void setEventId(Long eventId) {
/* 20 */     this.eventId = eventId;
/*    */   }
/*    */   
/*    */   public Position getPosition() {
/* 24 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Position position) {
/* 28 */     this.position = position;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return "AddBeaconLocationRequest [eventId=" + this.eventId + ", position=" + this.position + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 38 */     ValidatorUtils.isNull(this.eventId, "eventId");
/* 39 */     ValidatorUtils.isNull(this.position, "position");
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\AddBeaconLocationRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */