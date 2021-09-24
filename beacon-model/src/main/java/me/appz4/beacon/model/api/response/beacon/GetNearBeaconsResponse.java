/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.BeaconWithLocation;
/*    */ 
/*    */ public class GetNearBeaconsResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   List<BeaconWithLocation> beacons = new ArrayList();
/*    */   
/*    */   public List<BeaconWithLocation> getBeacons() {
/* 14 */     return this.beacons;
/*    */   }
/*    */   
/*    */   public void setBeacons(List<BeaconWithLocation> beacons) {
/* 18 */     this.beacons = beacons;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "GetNearBeaconsResponse [beacons=" + this.beacons + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetNearBeaconsResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */