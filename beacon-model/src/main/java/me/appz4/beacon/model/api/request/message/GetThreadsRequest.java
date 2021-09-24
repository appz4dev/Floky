/*    */ package me.appz4.beacon.model.api.request.message;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ 
/*    */ public class GetThreadsRequest extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Integer skip;
/*    */   private Integer limit;
/*    */   
/*    */   public Integer getSkip()
/*    */   {
/* 14 */     return this.skip;
/*    */   }
/*    */   
/*    */   public void setSkip(Integer skip) {
/* 18 */     this.skip = skip;
/*    */   }
/*    */   
/*    */   public Integer getLimit() {
/* 22 */     return this.limit;
/*    */   }
/*    */   
/*    */   public void setLimit(Integer limit) {
/* 26 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 31 */     return "GetThreadsRequest [skip=" + this.skip + ", limit=" + this.limit + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\message\GetThreadsRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */