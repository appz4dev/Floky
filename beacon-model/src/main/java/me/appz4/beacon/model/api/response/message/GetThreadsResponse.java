/*    */ package me.appz4.beacon.model.api.response.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.MessageThread;
/*    */ 
/*    */ public class GetThreadsResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   private List<MessageThread> threads = new ArrayList();
/*    */   
/*    */   public List<MessageThread> getThreads() {
/* 14 */     return this.threads;
/*    */   }
/*    */   
/*    */   public void setThreads(List<MessageThread> threads) {
/* 18 */     this.threads = threads;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "GetThreadsResponse [threads=" + this.threads + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\message\GetThreadsResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */