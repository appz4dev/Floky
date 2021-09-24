/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class ForgetPasswordRequest extends me.appz4.beacon.model.api.ApiRequest implements IRequestValidator
/*    */ {
/*    */   private String email;
/*    */   
/*    */   public String getEmail()
/*    */   {
/* 13 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 17 */     this.email = email;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 22 */     return "ForgetPasswordRequest [email=" + this.email + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 27 */     ValidatorUtils.hasText(this.email, "email");
/* 28 */     return true;
/*    */   }
/*    */ }