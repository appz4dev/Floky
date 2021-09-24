/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.model.UserConfig;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class SaveUserConfigRequest extends ApiRequestWithToken implements me.appz4.beacon.model.validator.IRequestValidator
/*    */ {
/*    */   private UserConfig config;
/*    */   
/*    */   public UserConfig getConfig()
/*    */   {
/* 14 */     return this.config;
/*    */   }
/*    */   
/*    */   public void setConfig(UserConfig config) {
/* 18 */     this.config = config;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 23 */     return "SaveUserConfigRequest [config=" + this.config + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 28 */     ValidatorUtils.isNull(this.config, "config");
/* 29 */     return true;
/*    */   }
/*    */ }