/*    */ package me.appz4.beacon.model.exception;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class ServiceException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 7832651378246861836L;
/*    */   private int errorCode;
/* 12 */   private List<String> parameters = new ArrayList();
/*    */   
/*    */ 
/*    */   public ServiceException() {}
/*    */   
/*    */   public ServiceException(Errors error)
/*    */   {
/* 19 */     super(error.getToken());
/* 20 */     this.errorCode = error.getCode();
/*    */   }
/*    */   
/*    */   public ServiceException(Errors error, String... parameters) {
/* 24 */     super(error.getToken());
/* 25 */     this.errorCode = error.getCode();
/* 26 */     for (String i : parameters) this.parameters.add(i);
/*    */   }
/*    */   
/*    */   public ServiceException(int errorCode)
/*    */   {
/* 31 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */   public ServiceException(int errorCode, String errorMessage) {
/* 35 */     super(errorMessage);
/* 36 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 40 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public List<String> getParameters() {
/* 44 */     return this.parameters;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\exception\ServiceException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */