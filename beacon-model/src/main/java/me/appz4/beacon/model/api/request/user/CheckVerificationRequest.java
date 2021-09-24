/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class CheckVerificationRequest extends ApiRequestWithToken implements me.appz4.beacon.model.validator.IRequestValidator
/*    */ {
/*    */   private String smsToken;
/*    */   
/*    */   public String getSmsToken()
/*    */   {
/* 13 */     return this.smsToken;
/*    */   }
/*    */   
/*    */   public void setSmsToken(String smsToken) {
/* 17 */     this.smsToken = smsToken;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 22 */     return "CheckVerificationRequest [smsToken=" + this.smsToken + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 27 */     ValidatorUtils.hasText(this.smsToken, "token");
/* 28 */     return true;
/*    */   }
/*    */ }
