/*    */ package me.appz4.beacon.model.api.response.user;
/*    */ 
/*    */ import me.appz4.beacon.model.model.UserWithToken;
/*    */ 
/*    */ public class LoginResponse extends me.appz4.beacon.model.api.ApiResponse
/*    */ {
/*    */   private UserWithToken user;
/*    */   
/*    */   public UserWithToken getUser()
/*    */   {
/* 11 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(UserWithToken user) {
/* 15 */     this.user = user;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 20 */     return "LoginResponse [user=" + this.user + "]";
/*    */   }
/*    */ }
