/*    */ package me.appz4.beacon.model.api.response.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class GetThreadStatusResponse extends ApiResponse
/*    */ {
/*  7 */   private long unread = 0L;
/*    */   
/*  9 */   private long total = 0L;
/*    */   
/*    */   public long getUnread() {
/* 12 */     return this.unread;
/*    */   }
/*    */   
/*    */   public void setUnread(long unread) {
/* 16 */     this.unread = unread;
/*    */   }
/*    */   
/*    */   public long getTotal() {
/* 20 */     return this.total;
/*    */   }
/*    */   
/*    */   public void setTotal(long total) {
/* 24 */     this.total = total;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 30 */     return "GetThreadStatusResponse [unread=" + this.unread + ", total=" + this.total + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\message\GetThreadStatusResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */