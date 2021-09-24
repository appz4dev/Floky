/*    */ package me.appz4.beacon.model.api.response.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class CheckUserResponse extends ApiResponse
/*    */ {
/*    */   private boolean email;
/*    */   private boolean username;
/*    */   
/*    */   public boolean isEmail()
/*    */   {
/* 12 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(boolean email) {
/* 16 */     this.email = email;
/*    */   }
/*    */   
/*    */   public boolean isUsername() {
/* 20 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(boolean username) {
/* 24 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "CheckUserResponse [email=" + this.email + ", username=" + this.username + "]";
/*    */   }
/*    */ }