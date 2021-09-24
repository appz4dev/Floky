/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*    */ 
/*    */ public class GetUserLostBeaconsRequest extends ApiRequestWithToken implements me.appz4.beacon.model.validator.IRequestValidator
/*    */ {
/*    */   private Long userId;
/*    */   
/*    */   public Long getUserId()
/*    */   {
/* 13 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 17 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 22 */     return "GetUserLostBeaconsRequest [userId=" + this.userId + "]";
/*    */   }
/*    */   
/*    */   public boolean onValidate() throws ValidationException
/*    */   {
/* 27 */     ValidatorUtils.isNull(this.userId, "userId");
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\GetUserLostBeaconsRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */