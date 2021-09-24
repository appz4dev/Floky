/*    */ package me.appz4.beacon.model.exception;
/*    */ 
/*    */ public class ValidationException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -6454708895391757907L;
/*    */   private String[] params;
/*    */   
/*    */   public ValidationException() {}
/*    */   
/*    */   public ValidationException(String error)
/*    */   {
/* 12 */     super(error);
/*    */   }
/*    */   
/*    */   public ValidationException(String error, String... params) {
/* 16 */     super(error);
/* 17 */     this.params = params;
/*    */   }
/*    */   
/*    */   public ValidationException(Errors error, String... params) {
/* 21 */     this(error.getToken(), params);
/*    */   }
/*    */   
/*    */   public String[] getParams() {
/* 25 */     return this.params;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\exception\ValidationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */