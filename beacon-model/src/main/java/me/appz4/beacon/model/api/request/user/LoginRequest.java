/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequest;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class LoginRequest extends ApiRequest implements IRequestValidator
/*    */ {
/*    */   private String email;
/*    */   private String password;
/*    */   
/*    */   public String getEmail()
/*    */   {
/* 16 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 20 */     this.email = email;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 24 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 28 */     this.password = password;
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 33 */     if (!ValidatorUtils.hasText(this.email)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "email" });
/* 34 */     if (!ValidatorUtils.hasText(this.password)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "password" });
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 40 */     return "LoginRequest [email=" + this.email + ", password=" + this.password + "]";
/*    */   }
/*    */ }
