/*    */ package me.appz4.beacon.model.api.request.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ 
/*    */ public class DeleteThreadRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long threadId;
/*    */   
/*    */   public Long getThreadId()
/*    */   {
/* 13 */     return this.threadId;
/*    */   }
/*    */   
/*    */   public void setThreadId(Long threadId) {
/* 17 */     this.threadId = threadId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 22 */     return "DeleteThreadRequest [threadId=" + this.threadId + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 27 */     if (this.threadId == null) {
/* 28 */       throw new ValidationException(me.appz4.beacon.model.exception.Errors.ERROR_PARAMETER, new String[] { "threadId" });
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\message\DeleteThreadRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */