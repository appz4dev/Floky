/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ 
/*    */ 
/*    */ public class EditUserRequest
/*    */   extends ApiRequestWithToken
/*    */   implements IRequestValidator
/*    */ {
/*    */   private String password;
/*    */   private String username;
/*    */   private String fullname;
/*    */   private String phone;
/*    */   private String icon;
/*    */   
/*    */   public String getPassword()
/*    */   {
/* 20 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 24 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 28 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 32 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getFullname() {
/* 36 */     return this.fullname;
/*    */   }
/*    */   
/*    */   public void setFullname(String fullname) {
/* 40 */     this.fullname = fullname;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 44 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 48 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 52 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 56 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 61 */     return "EditUserRequest [password=" + this.password + ", username=" + this.username + ", fullname=" + this.fullname + ", phone=" + this.phone + ", icon=" + this.icon + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate()
/*    */     throws ValidationException
/*    */   {
/* 67 */     return true;
/*    */   }
/*    */ }
