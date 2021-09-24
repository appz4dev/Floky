/*    */ package me.appz4.beacon.model.api.response.user;
/*    */ 
/*    */ import me.appz4.beacon.model.model.UserConfig;
/*    */ 
/*    */ public class GetUserConfigResponse extends me.appz4.beacon.model.api.ApiResponse
/*    */ {
/*    */   private UserConfig config;
/*    */   
/*    */   public UserConfig getConfig()
/*    */   {
/* 11 */     return this.config;
/*    */   }
/*    */   
/*    */   public void setConfig(UserConfig config) {
/* 15 */     this.config = config;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 20 */     return "GetUserConfigResponse [config=" + this.config + "]";
/*    */   }
/*    */ }
