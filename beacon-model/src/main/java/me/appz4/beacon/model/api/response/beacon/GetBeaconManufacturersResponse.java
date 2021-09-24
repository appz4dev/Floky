/*    */ package me.appz4.beacon.model.api.response.beacon;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.appz4.beacon.model.api.ApiResponse;
/*    */ import me.appz4.beacon.model.model.BeaconManufacturer;
/*    */ 
/*    */ public class GetBeaconManufacturersResponse
/*    */   extends ApiResponse
/*    */ {
/* 11 */   private List<BeaconManufacturer> types = new ArrayList();
/*    */   
/*    */   public List<BeaconManufacturer> getTypes() {
/* 14 */     return this.types;
/*    */   }
/*    */   
/*    */   public void setTypes(List<BeaconManufacturer> types) {
/* 18 */     this.types = types;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "GetBeaconManufacturersResponse [types=" + this.types + ", isError()=" + isError() + ", getErrorCode()=" + getErrorCode() + ", getErrorMessage()=" + getErrorMessage() + "]";
/*    */   }
/*    */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\response\beacon\GetBeaconManufacturersResponse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */