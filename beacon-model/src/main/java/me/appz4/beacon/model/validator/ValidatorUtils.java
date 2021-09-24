/*    */ package me.appz4.beacon.model.validator;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import me.appz4.beacon.model.exception.Errors;
/*    */ import me.appz4.beacon.model.exception.ValidationException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidatorUtils
/*    */ {
/*    */   public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
/* 13 */   public static final Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
/*    */   
/*    */   public static void isNull(Object field, String name) throws ValidationException {
/* 16 */     if (field == null) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { name });
/*    */   }
/*    */   
/*    */   public static void hasText(String field, String name) throws ValidationException {
/* 20 */     if (!hasText(field)) {
/* 21 */       throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { name });
/*    */     }
/*    */   }
/*    */   
/*    */   public static boolean isValidEmail(String data) {
/* 26 */     if (data == null) return false;
/* 27 */     if (!hasText(data)) return false;
/* 28 */     Matcher matcher = emailPattern.matcher(data);
/* 29 */     if (!matcher.matches()) {
/* 30 */       return false;
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean hasText(CharSequence str) {
/* 36 */     if (!hasLength(str)) {
/* 37 */       return false;
/*    */     }
/* 39 */     int strLen = str.length();
/* 40 */     for (int i = 0; i < strLen; i++) {
/* 41 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 42 */         return true;
/*    */       }
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean hasLength(CharSequence str) {
/* 49 */     return (str != null) && (str.length() > 0);
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\validator\ValidatorUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */