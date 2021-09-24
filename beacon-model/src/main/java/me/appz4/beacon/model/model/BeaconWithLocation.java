/*    */ package me.appz4.beacon.model.model;
/*    */ 
/*    */ 
/*    */ public class BeaconWithLocation
/*    */ {
/*    */   private Beacon beacon;
/*    */   private Position position;
/*    */   private Double distance;
/*    */   
/*    */   public Beacon getBeacon()
/*    */   {
/* 12 */     return this.beacon;
/*    */   }
/*    */   
/*    */   public void setBeacon(Beacon beacon) {
/* 16 */     this.beacon = beacon;
/*    */   }
/*    */   
/*    */   public Position getPosition() {
/* 20 */     return this.position;
/*    */   }
/*    */   
/*    */   public void setPosition(Position position) {
/* 24 */     this.position = position;
/*    */   }
/*    */   
/*    */   public Double getDistance() {
/* 28 */     return this.distance;
/*    */   }
/*    */   
/*    */   public void setDistance(Double distance) {
/* 32 */     this.distance = distance;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 37 */     return "BeaconWithLocation [beacon=" + this.beacon + ", position=" + this.position + ", distance=" + this.distance + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\BeaconWithLocation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */