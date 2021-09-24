/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import me.appz4.beacon.model.model.Beacon;
/*    */ 
/*    */ public class GetBeaconResponse extends me.appz4.beacon.model.api.ApiResponse
/*    */ {
/*    */   private Beacon beacon;
/*    */   
/*    */   public Beacon getBeacon()
/*    */   {
/* 11 */     return this.beacon;
/*    */   }
/*    */   
/*    */   public void setBeacon(Beacon beacon) {
/* 15 */     this.beacon = beacon;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 20 */     return "GetBeaconResponse [beacon=" + this.beacon + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetBeaconResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */