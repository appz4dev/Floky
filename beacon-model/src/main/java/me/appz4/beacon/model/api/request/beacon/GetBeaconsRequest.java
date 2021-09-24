/*    */ package me.appz4.beacon.model.api.request.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*    */ 
/*    */ public class GetBeaconsRequest extends ApiRequestWithToken
/*    */ {
/*    */   private Integer skip;
/*    */   private Integer limit;
/*    */   
/*    */   public Integer getSkip()
/*    */   {
/* 12 */     return this.skip;
/*    */   }
/*    */   
/*    */   public void setSkip(Integer skip) {
/* 16 */     this.skip = skip;
/*    */   }
/*    */   
/*    */   public Integer getLimit() {
/* 20 */     return this.limit;
/*    */   }
/*    */   
/*    */   public void setLimit(Integer limit) {
/* 24 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "GetBeaconsRequest [skip=" + this.skip + ", limit=" + this.limit + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\GetBeaconsRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */