/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.Beacon;
/*    */ 
/*    */ public class GetBeaconsResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   private List<Beacon> beacons = new ArrayList();
/*    */   
/*    */   public List<Beacon> getBeacons() {
/* 14 */     return this.beacons;
/*    */   }
/*    */   
/*    */   public void setBeacons(List<Beacon> beacons) {
/* 18 */     this.beacons = beacons;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 23 */     return "GetBeaconsResponse [beacons=" + this.beacons + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetBeaconsResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */