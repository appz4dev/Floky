/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.BeaconLocation;
/*    */ 
/*    */ public class ListBeaconLocationsResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   private List<BeaconLocation> locations = new ArrayList();
/*    */   
/*    */   public List<BeaconLocation> getLocations() {
/* 14 */     return this.locations;
/*    */   }
/*    */   
/*    */   public void setLocations(List<BeaconLocation> locations) {
/* 18 */     this.locations = locations;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "ListBeaconLocationsResponse [locations=" + this.locations + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\ListBeaconLocationsResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */