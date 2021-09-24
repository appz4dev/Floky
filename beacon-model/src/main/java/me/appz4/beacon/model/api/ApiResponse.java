/*    */ package me.appz4.beacon.model.api;
/*    */ 
/*    */ public class ApiResponse
/*    */ {
/*  5 */   private boolean error = false;
/*    */   
/*  7 */   private int errorCode = 0;
/*    */   
/*  9 */   private String errorMessage = "";
/*    */   
/*    */   public boolean isError() {
/* 12 */     return this.error;
/*    */   }
/*    */   
/*    */   public void setError(boolean error) {
/* 16 */     this.error = error;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 20 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public void setErrorCode(int errorCode) {
/* 24 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */   public String getErrorMessage() {
/* 28 */     return this.errorMessage;
/*    */   }
/*    */   
/*    */   public void setErrorMessage(String errorMessage) {
/* 32 */     this.errorMessage = errorMessage;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 37 */     return "ApiResponse [error=" + this.error + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\ApiResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */