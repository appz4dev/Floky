/*    */ package me.appz4.beacon.model.gcm;
/*    */ 
/*    */ import me.appz4.beacon.model.gcm.android.GcmInternal;
/*    */ import me.appz4.beacon.model.gcm.android.GcmMessage;
/*    */ 
/*    */ public class GcmMessageFactory
/*    */ {
/*    */   public static IGcmMessage createGcmMessage(me.appz4.beacon.model.model.GcmToken.TokenTypes type, String to, GcmMessageTypes mt, String str, GcmData data)
/*    */   {
/* 10 */     switch (type) {
/* 11 */     case ANDROID:  return createAndroidMessage(to, mt, str, data);
/* 12 */     case IOS:  return createIosMessage(to, mt, str, data);
/*    */     }
/* 14 */     return null;
/*    */   }
/*    */   
/*    */   private static IGcmMessage createAndroidMessage(String to, GcmMessageTypes type, String str, GcmData data) {
/* 18 */     GcmMessage message = new GcmMessage();
/* 19 */     GcmInternal internalData = new GcmInternal();
/* 20 */     internalData.setType(type);
/* 21 */     internalData.setMessage(str);
/* 22 */     internalData.setData(data);
/* 23 */     message.setData(internalData);
/* 24 */     message.setTo(to);
/* 25 */     return message;
/*    */   }
/*    */   
/*    */   private static IGcmMessage createIosMessage(String to, GcmMessageTypes type, String str, GcmData data) {
/* 29 */     GcmMessage message = new GcmMessage();
/* 30 */     GcmInternal internalData = new GcmInternal();
/* 31 */     internalData.setType(type);
/* 32 */     internalData.setMessage(str);
/* 33 */     internalData.setData(data);
/* 34 */     message.setData(internalData);
/* 35 */     message.setTo(to);
/* 36 */     return message;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\gcm\GcmMessageFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */