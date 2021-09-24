/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserWithLocation
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -378401479885226449L;
/*    */   private Long id;
/*    */   private Long userId;
/*    */   private String username;
/*    */   private String icon;
/*    */   private String phone;
/*    */   private Position position;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 22 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 26 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 30 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 34 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 38 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 42 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getPhone() {
/* 46 */     return this.phone;
/*    */   }
/*    */   
/*    */   public void setPhone(String phone) {
/* 50 */     this.phone = phone;
/*    */   }
/*    */   
/*    */   public String getIcon() {
/* 54 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void setIcon(String icon) {
/* 58 */     this.icon = icon;
/*    */   }
/*    */   
/*    */   public Position getPosition() {
/* 62 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Position position) {
/* 66 */     this.position = position;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 71 */     return "UserWithLocation [userId=" + this.userId + ", username=" + this.username + ", icon=" + this.icon + ", position=" + this.position + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\UserWithLocation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */