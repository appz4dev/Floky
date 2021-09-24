/*    */ package me.appz4.beacon.model.gcm.android;
/*    */ 
/*    */ import me.appz4.beacon.model.gcm.IGcmMessage;
/*    */ 
/*    */ public class GcmMessage implements IGcmMessage
/*    */ {
/*    */   private String to;
/*    */   private GcmInternal data;
/*    */   
/*    */   public String getTo()
/*    */   {
/* 12 */     return this.to;
/*    */   }
/*    */   
/*    */   public void setTo(String to) {
/* 16 */     this.to = to;
/*    */   }
/*    */   
/*    */   public GcmInternal getData() {
/* 20 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(GcmInternal data) {
/* 24 */     this.data = data;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 29 */     return "GcmMessage [to=" + this.to + ", data=" + this.data + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\gcm\android\GcmMessage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */