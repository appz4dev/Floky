/*    */ package me.appz4.beacon.model.exception;
/*    */ 
/*    */ public enum Errors {
/*  4 */   ERROR_GENERAL(1, "general_error"), 
/*  5 */   ERROR_CLIENTID(2, "clientid_error"), 
/*  6 */   ERROR_PARAMETER(3, "parameter_missing"), 
/*  7 */   ERROR_EMAIL_EXISTS(4, "email_exists"), 
/*  8 */   ERROR_USERNAME_EXISTS(5, "username_exists"), 
/*  9 */   LOGIN_FAILED(6, "login_failed"), 
/* 10 */   ERROR_TOKEN(7, "token_error"), 
/* 11 */   ERROR_BEACON_NOT_FOUND(8, "beacon_not_found"), 
/* 12 */   ERROR_MESSAGE_USER_THREAD(9, "message_user_thread"), 
/* 13 */   ERROR_MESSAGE_USER_THREAD_BOTH(9, "message_user_thread_both"), 
/* 14 */   ERROR_THREAD_NOT_FOUND(10, "thread_not_found"), 
/* 15 */   ERROR_BEACON_ALREADY_EXISTS(11, "beacon_already_exists"), 
/* 16 */   ERROR_BEACON_NAME_ALREADY_EXISTS(12, "beacon_name_already_exists"), 
/* 17 */   ERROR_TYPE_NOT_FOUND(13, "beacon_type_not_found"), 
/* 18 */   ERROR_BEACON_IMAGE_LIMIT(14, "beacon_image_limit"), 
/* 19 */   ERROR_BEACON_IMAGE_NOT_FOUND(15, "beacon_image_not_found"), 
/* 20 */   ERROR_USER_VERIFIED(16, "user_verified"), 
/* 21 */   ERROR_ITEM_NOT_FOUND(10, "item_not_found"), 
/* 22 */   LOGOUT_FAILED(999, "logout_failed");
/*    */   
/*    */   private int code;
/*    */   private String token;
/*    */   
/*    */   private Errors(int code, String token)
/*    */   {
/* 29 */     this.code = code;
/* 30 */     this.token = token;
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 34 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 38 */     return this.token;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\exception\Errors.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */