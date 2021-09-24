/*    */ package me.appz4.beacon.model.gcm.android;
/*    */ 
/*    */ import me.appz4.beacon.model.gcm.GcmData;
/*    */ import me.appz4.beacon.model.gcm.GcmMessageTypes;
/*    */ 
/*    */ 
/*    */ public class GcmInternal
/*    */ {
/*    */   private GcmMessageTypes type;
/*    */   private String message;
/*    */   private GcmData data;
/*    */   
/*    */   public GcmMessageTypes getType()
/*    */   {
/* 15 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(GcmMessageTypes type) {
/* 19 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 23 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 27 */     this.message = message;
/*    */   }
/*    */   
/*    */   public GcmData getData() {
/* 31 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(GcmData data) {
/* 35 */     this.data = data;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 40 */     return "GcmInternal [type=" + this.type + ", message=" + this.message + ", data=" + this.data + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\gcm\android\GcmInternal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */