/*    */ package me.appz4.beacon.model.util;
/*    */ 
/*    */ import me.appz4.beacon.model.model.Position;
/*    */ 
/*    */ public class GeoUtils
/*    */ {
/*    */   public static final int EARTH_RADIUS = 6371;
/*    */   
/*    */   public static double getDistance(Position p1, Position p2) {
/* 10 */     double rLat1 = Math.toRadians(p1.getLatitude().doubleValue());
/* 11 */     double rLat2 = Math.toRadians(p2.getLatitude().doubleValue());
/* 12 */     double rDiff1 = Math.toRadians(p2.getLatitude().doubleValue() - p1.getLatitude().doubleValue());
/* 13 */     double rDiff2 = Math.toRadians(p2.getLongitude().doubleValue() - p1.getLongitude().doubleValue());
/* 14 */     double a = Math.sin(rDiff1 / 2.0D) * Math.sin(rDiff1 / 2.0D) + Math.cos(rLat1) * Math.cos(rLat2) * Math.sin(rDiff2 / 2.0D) * Math.sin(rDiff2 / 2.0D);
/* 15 */     double c = 2.0D * Math.atan2(Math.sqrt(a), Math.sqrt(1.0D - a));
/* 16 */     return 6371.0D * c;
/*    */   }
/*    */ }
