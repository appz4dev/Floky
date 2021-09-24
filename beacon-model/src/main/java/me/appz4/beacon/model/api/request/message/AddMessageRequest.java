/*    */ package me.appz4.beacon.model.api.request.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class AddMessageRequest
/*    */   extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long threadId;
/*    */   private Long toUserId;
/*    */   private String message;
/*    */   
/*    */   public Long getThreadId()
/*    */   {
/* 18 */     return this.threadId;
/*    */   }
/*    */   
/*    */   public void setThreadId(Long threadId) {
/* 22 */     this.threadId = threadId;
/*    */   }
/*    */   
/*    */   public Long getToUserId() {
/* 26 */     return this.toUserId;
/*    */   }
/*    */   
/*    */   public void setToUserId(Long toUserId) {
/* 30 */     this.toUserId = toUserId;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 34 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 38 */     this.message = message;
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 43 */     if ((this.threadId == null) && (this.toUserId == null)) {
/* 44 */       throw new ValidationException(Errors.ERROR_MESSAGE_USER_THREAD, new String[0]);
/*    */     }
/* 46 */     if ((this.threadId != null) && (this.toUserId != null)) {
/* 47 */       throw new ValidationException(Errors.ERROR_MESSAGE_USER_THREAD_BOTH, new String[0]);
/*    */     }
/* 49 */     if (!ValidatorUtils.hasText(this.message)) {
/* 50 */       throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "message" });
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\message\AddMessageRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */