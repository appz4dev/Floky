/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ public enum ImageType {
/*  4 */   LARGE(1024, 768),  THUMBNAIL(200, 200);
/*    */   
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   private ImageType(int width, int height)
/*    */   {
/* 11 */     this.width = width;
/* 12 */     this.height = height;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 16 */     return this.width;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 20 */     return this.height;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\ImageType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */