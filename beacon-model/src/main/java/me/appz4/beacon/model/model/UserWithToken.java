/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ public class UserWithToken
/*    */ {
/*    */   private User user;
/*    */   private Token token;
/*    */   
/*    */   public User getUser()
/*    */   {
/* 10 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(User user) {
/* 14 */     this.user = user;
/*    */   }
/*    */   
/*    */   public Token getToken() {
/* 18 */     return this.token;
/*    */   }
/*    */   
/*    */   public void setToken(Token token) {
/* 22 */     this.token = token;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 27 */     return "UserWithToken [user=" + this.user + ", token=" + this.token + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\UserWithToken.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */