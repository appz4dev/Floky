/*    */ package me.appz4.beacon.model.api.response.message;
/*    */ 
/*    */ import me.appz4.beacon.model.model.MessageThread;
/*    */ 
/*    */ public class GetThreadResponse extends me.appz4.beacon.model.api.ApiResponse
/*    */ {
/*    */   private MessageThread thread;
/*    */   
/*    */   public MessageThread getThread()
/*    */   {
/* 11 */     return this.thread;
/*    */   }
/*    */   
/*    */   public void setThread(MessageThread thread) {
/* 15 */     this.thread = thread;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 21 */     return "GetThreadResponse [thread=" + this.thread + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }