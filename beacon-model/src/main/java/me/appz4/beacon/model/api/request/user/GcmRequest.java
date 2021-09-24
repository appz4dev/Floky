/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
		import me.appz4.beacon.model.model.GcmToken;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class GcmRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private GcmToken.TokenTypes type;
/*    */   private String gcmToken;
/*    */   
/*    */   public GcmToken.TokenTypes getType()
/*    */   {
/* 16 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(GcmToken.TokenTypes type) {
/* 20 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getGcmToken() {
/* 24 */     return this.gcmToken;
/*    */   }
/*    */   
/*    */   public void setGcmToken(String gcmToken) {
/* 28 */     this.gcmToken = gcmToken;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return "GcmRequest [type=" + this.type + ", gcmToken=" + this.gcmToken + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 38 */     ValidatorUtils.isNull(this.type, "type");
/* 39 */     ValidatorUtils.isNull(this.gcmToken, "gcmToken");
/* 40 */     return true;
/*    */   }
/*    */ }
