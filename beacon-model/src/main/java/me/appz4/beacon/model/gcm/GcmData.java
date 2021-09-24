/*    */ package me.appz4.beacon.model.gcm;
/*    */ 
/*    */ import me.appz4.beacon.model.model.Beacon;
/*    */ import me.appz4.beacon.model.model.BeaconLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GcmData
/*    */ {
/*    */   private Long eventId;
/*    */   private Beacon beacon;
/*    */   private BeaconLocation location;
/*    */   private Long messageThreadId;
/*    */   private Long foundUserId;
/*    */   
/*    */   public Long getEventId()
/*    */   {
/* 19 */     return this.eventId;
/*    */   }
/*    */   
/*    */   public void setEventId(Long eventId) {
/* 23 */     this.eventId = eventId;
/*    */   }
/*    */   
/*    */   public Beacon getBeacon() {
/* 27 */     return this.beacon;
/*    */   }
/*    */   
/*    */   public void setBeacon(Beacon beacon) {
/* 31 */     this.beacon = beacon;
/*    */   }
/*    */   
/*    */   public BeaconLocation getLocation() {
/* 35 */     return this.location;
/*    */   }
/*    */   
/*    */   public void setLocation(BeaconLocation location) {
/* 39 */     this.location = location;
/*    */   }
/*    */   
/*    */   public Long getMessageThreadId() {
/* 43 */     return this.messageThreadId;
/*    */   }
/*    */   
/*    */   public void setMessageThreadId(Long messageThreadId) {
/* 47 */     this.messageThreadId = messageThreadId;
/*    */   }
/*    */   
/*    */   public Long getFoundUserId() {
/* 51 */     return this.foundUserId;
/*    */   }
/*    */   
/*    */   public void setFoundUserId(Long foundUserId) {
/* 55 */     this.foundUserId = foundUserId;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 60 */     return "GcmData [eventId=" + this.eventId + ", beacon=" + this.beacon + ", location=" + this.location + ", foundUserId=" + this.foundUserId + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\gcm\GcmData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */