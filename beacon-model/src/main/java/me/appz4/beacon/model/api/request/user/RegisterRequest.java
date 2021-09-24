/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequest;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegisterRequest
/*    */   extends ApiRequest
/*    */   implements IRequestValidator
/*    */ {
/*    */   private String email;
/*    */   private String password;
/*    */   private String username;
/*    */   private String fullname;
/*    */   private String phone;
/*    */   private String icon;
/* 23 */   private Integer privacy = Integer.valueOf(0);
/*    */   
/*    */   public String getEmail() {
/* 26 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 30 */     this.email = email;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 34 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 38 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 42 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 46 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getFullname() {
/* 50 */     return this.fullname;
/*    */   }
/*    */   
/*    */   public void setFullname(String fullname) {
/* 54 */     this.fullname = fullname;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 58 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 62 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 66 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 70 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public Integer getPrivacy() {
/* 74 */     return this.privacy;
/*    */   }
/*    */   
/*    */   public void setPrivacy(Integer privacy) {
/* 78 */     this.privacy = privacy;
/*    */   }
/*    */   
/*    */   
/*    */   
/*    */   public boolean onValidate()
/*    */     throws ValidationException
/*    */   {
/* 89 */     if (!ValidatorUtils.hasText(this.email)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "email" });
/* 90 */     if (!ValidatorUtils.hasText(this.username)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "username" });
/* 91 */     if (!ValidatorUtils.hasText(this.fullname)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "fullname" });
/* 92 */     if (!ValidatorUtils.hasText(this.password)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "password" });
/* 93 */     if (!ValidatorUtils.hasText(this.phone)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "phone" });
/* 94 */     if (!ValidatorUtils.hasText(this.icon)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "icon" });
/* 95 */     if (this.privacy.intValue() != 1) {
/* 96 */       throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "privacy" });
/*    */     }
/* 98 */     return true;
/*    */   }
/*    */
@Override
public String toString() {
	return "RegisterRequest [email=" + email + ", password=" + password + ", username=" + username + ", fullname="
			+ fullname + ", phone=" + phone + ", icon=" + icon + ", privacy=" + privacy + ", getClientId()="
			+ getClientId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
} }
