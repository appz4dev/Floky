/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.IRequestValidator;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class GetUpdatedBeaconsRequest
/*    */   extends ApiRequestWithToken implements IRequestValidator
/*    */ {
/*    */   private Long timeStamp;
/*    */   private Integer skip;
/*    */   private Integer limit;
/*    */   
/*    */   public Long getTimeStamp()
/*    */   {
/* 17 */     return this.timeStamp;
/*    */   }
/*    */   
/*    */   public void setTimeStamp(Long timeStamp) {
/* 21 */     this.timeStamp = timeStamp;
/*    */   }
/*    */   
/*    */   public Integer getSkip() {
/* 25 */     return this.skip;
/*    */   }
/*    */   
/*    */   public void setSkip(Integer skip) {
/* 29 */     this.skip = skip;
/*    */   }
/*    */   
/*    */   public Integer getLimit() {
/* 33 */     return this.limit;
/*    */   }
/*    */   
/*    */   public void setLimit(Integer limit) {
/* 37 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 42 */     ValidatorUtils.isNull(this.timeStamp, "timeStamp");
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\GetUpdatedBeaconsRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */