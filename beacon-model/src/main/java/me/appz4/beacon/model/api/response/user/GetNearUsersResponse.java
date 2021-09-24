/*    */ package me.appz4.beacon.model.api.response.user;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.UserWithLocation;
/*    */ 
/*    */ public class GetNearUsersResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   List<UserWithLocation> result = new ArrayList();
/*    */   
/*    */   public List<UserWithLocation> getResult() {
/* 14 */     return this.result;
/*    */   }
/*    */   
/*    */   public void setResult(List<UserWithLocation> result) {
/* 18 */     this.result = result;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 23 */     return "GetNearUsersResponse [result=" + this.result + "]";
/*    */   }
/*    */ }
