/*    */ package me.appz4.beacon.model.api.request.user;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequest;
/*    */ 
/*    */ public class CheckUserRequest extends ApiRequest
/*    */ {
/*    */   private String email;
/*    */   private String username;
/*    */   
/*    */   public String getEmail()
/*    */   {
/* 12 */     return this.email;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 16 */     this.email = email;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 20 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 24 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "CheckUserRequest [email=" + this.email + ", username=" + this.username + "]";
/*    */   }
/*    */ }