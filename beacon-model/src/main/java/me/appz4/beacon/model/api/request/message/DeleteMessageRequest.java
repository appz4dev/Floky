/*    */ package me.appz4.beacon.model.api.request.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class DeleteMessageRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long threadId;
/*    */   private Long messageId;
/*    */   
/*    */   public Long getThreadId()
/*    */   {
/* 15 */     return this.threadId;
/*    */   }
/*    */   
/*    */   public void setThreadId(Long threadId) {
/* 19 */     this.threadId = threadId;
/*    */   }
/*    */   
/*    */   public Long getMessageId() {
/* 23 */     return this.messageId;
/*    */   }
/*    */   
/*    */   public void setMessageId(Long messageId) {
/* 27 */     this.messageId = messageId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 32 */     return "DeleteMessageRequest [threadId=" + this.threadId + ", messageId=" + this.messageId + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 37 */     ValidatorUtils.isNull(this.threadId, "threadId");
/* 38 */     ValidatorUtils.isNull(this.messageId, "messageId");
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\message\DeleteMessageRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */