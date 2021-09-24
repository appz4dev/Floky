/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserConfig
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 8309382331359200010L;
/*    */   public static final String FIELD_LOCATION = "showLocation";
/*    */   public static final String FIELD_PHONE = "showPhone";
/* 15 */   private Map<String, Object> values = new HashMap();
/*    */   
/*    */   public Object getValue(String key) {
/* 18 */     return this.values.get(key);
/*    */   }
/*    */   
/*    */   public String getStringValue(String key, String defaultValue) {
/* 22 */     Object value = getValue(key);
/* 23 */     if (value == null) return defaultValue;
/* 24 */     return (String)value;
/*    */   }
/*    */   
/*    */   public boolean getBoolValue(String key) {
/* 28 */     Object value = getValue(key);
/* 29 */     if (value == null) return false;
/* 30 */     return ((Boolean)value).booleanValue();
/*    */   }
/*    */   
/*    */   public void putValue(String key, String value) {
/* 34 */     this.values.put(key, value);
/*    */   }
/*    */   
/*    */   public void putValue(String key, boolean value) {
/* 38 */     this.values.put(key, Boolean.valueOf(value));
/*    */   }
/*    */   
/*    */   public Map<String, Object> getValues() {
/* 42 */     return this.values;
/*    */   }
/*    */   
/*    */   public void setValues(Map<String, Object> values) {
/* 46 */     this.values = values;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 51 */     return "UserConfig [values=" + this.values + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\UserConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */