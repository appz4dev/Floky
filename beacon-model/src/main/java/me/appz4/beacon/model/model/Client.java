/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ 
/*    */ public class Client
/*    */ {
/*    */   private String token;
/*    */   private String name;
/*    */   private Integer status;
/*    */   
/*    */   public Client() {}
/*    */   
/*    */   public Client(String name, String token, Integer status)
/*    */   {
/* 14 */     this.name = name;
/* 15 */     this.token = token;
/* 16 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 20 */     return this.token;
/*    */   }
/*    */   
/*    */   public void setToken(String token) {
/* 24 */     this.token = token;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 28 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 32 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Integer getStatus() {
/* 36 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(Integer status) {
/* 40 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 45 */     return "Client [token=" + this.token + ", name=" + this.name + ", status=" + this.status + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\Client.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */