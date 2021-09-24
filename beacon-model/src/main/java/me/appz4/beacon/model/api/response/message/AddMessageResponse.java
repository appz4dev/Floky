/*    */ package me.appz4.beacon.model.api.response.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class AddMessageResponse extends ApiResponse
/*    */ {
/*    */   private Long threadId;
/*    */   
/*    */   public Long getThreadId() {
/* 10 */     return this.threadId;
/*    */   }
/*    */   
/*    */   public void setThreadId(Long threadId) {
/* 14 */     this.threadId = threadId;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return "AddMessageResponse [threadId=" + this.threadId + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\message\AddMessageResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */