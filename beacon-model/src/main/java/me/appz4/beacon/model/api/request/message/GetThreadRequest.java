/*    */ package me.appz4.beacon.model.api.request.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ 
/*    */ public class GetThreadRequest
/*    */   extends ApiRequestWithToken
/*    */   implements IRequestValidator
/*    */ {
/*    */   private Long toUserId;
/*    */   private Long threadId;
/*    */   private Integer skip;
/*    */   private Integer limit;
/*    */   
/*    */   public Long getToUserId()
/*    */   {
/* 19 */     return this.toUserId;
/*    */   }
/*    */   
/*    */   public void setToUserId(Long toUserId) {
/* 23 */     this.toUserId = toUserId;
/*    */   }
/*    */   
/*    */   public Long getThreadId() {
/* 27 */     return this.threadId;
/*    */   }
/*    */   
/*    */   public void setThreadId(Long threadId) {
/* 31 */     this.threadId = threadId;
/*    */   }
/*    */   
/*    */   public Integer getSkip() {
/* 35 */     return this.skip;
/*    */   }
/*    */   
/*    */   public void setSkip(Integer skip) {
/* 39 */     this.skip = skip;
/*    */   }
/*    */   
/*    */   public Integer getLimit() {
/* 43 */     return this.limit;
/*    */   }
/*    */   
/*    */   public void setLimit(Integer limit) {
/* 47 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 52 */     return "GetThreadRequest [toUserId=" + this.toUserId + ", threadId=" + this.threadId + ", skip=" + this.skip + ", limit=" + this.limit + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate()
/*    */     throws ValidationException
/*    */   {
/* 58 */     if ((this.threadId == null) && (this.toUserId == null)) {
/* 59 */       throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "threadId or userId" });
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\message\GetThreadRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */