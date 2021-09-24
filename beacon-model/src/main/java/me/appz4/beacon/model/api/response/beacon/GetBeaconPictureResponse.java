/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class GetBeaconPictureResponse extends ApiResponse
/*    */ {
/*    */   private String fullUrl;
/*    */   private String thumbUrl;
/*    */   
/*    */   public String getFullUrl()
/*    */   {
/* 12 */     return this.fullUrl;
/*    */   }
/*    */   
/*    */   public void setFullUrl(String fullUrl) {
/* 16 */     this.fullUrl = fullUrl;
/*    */   }
/*    */   
/*    */   public String getThumbUrl() {
/* 20 */     return this.thumbUrl;
/*    */   }
/*    */   
/*    */   public void setThumbUrl(String thumbUrl) {
/* 24 */     this.thumbUrl = thumbUrl;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "GetBeaconPictureResponse [fullUrl=" + this.fullUrl + ", thumbUrl=" + this.thumbUrl + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetBeaconPictureResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */