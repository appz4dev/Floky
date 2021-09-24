/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.model.Position;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class CreateUserLocationRequest extends ApiRequestWithToken implements me.appz4.beacon.model.validator.IRequestValidator
/*    */ {
/*    */   private Position position;
/*    */   
/*    */   public Position getPosition()
/*    */   {
/* 14 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Position position) {
/* 18 */     this.position = position;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 23 */     return "CreateUserLocationRequest [position=" + this.position + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 28 */     ValidatorUtils.isNull(this.position, "position");
/* 29 */     ValidatorUtils.isNull(this.position.getLatitude(), "latitude");
/* 30 */     ValidatorUtils.isNull(this.position.getLongitude(), "longitude");
/* 31 */     return true;
/*    */   }
/*    */ }