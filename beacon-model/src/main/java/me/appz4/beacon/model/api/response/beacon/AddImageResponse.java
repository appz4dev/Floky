/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ 
/*    */ public class AddImageResponse extends ApiResponse
/*    */ {
/*    */   private String fullUrl;
/*    */   private String thumbnailUrl;
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
/*    */   public String getThumbnailUrl() {
/* 20 */     return this.thumbnailUrl;
/*    */   }
/*    */   
/*    */   public void setThumbnailUrl(String thumbnailUrl) {
/* 24 */     this.thumbnailUrl = thumbnailUrl;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "AddImageResponse [fullUrl=" + this.fullUrl + ", thumbnailUrl=" + this.thumbnailUrl + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\AddImageResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */