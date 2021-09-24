/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ public enum BeaconStatus
/*    */ {
/*  5 */   OK(1),  LOST(2);
/*    */   
/*    */   private int status;
/*    */   
/*    */   private BeaconStatus(int status) {
/* 10 */     this.status = status;
/*    */   }
/*    */   
/*    */   public static BeaconStatus getForStatus(int status) {
/* 14 */     for (BeaconStatus i : values()) {
/* 15 */       if (i.status == status) return i;
/*    */     }
/* 17 */     return null;
/*    */   }
/*    */   
/*    */   public int getStatus() {
/* 21 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\BeaconStatus.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */