/*     */ package me.appz4.beacon.model.api.request.beacon;
/*     */ 
/*     */ import me.appz4.beacon.model.api.ApiRequestWithToken;
/*     */ import me.appz4.beacon.model.exception.Errors;
/*     */ import me.appz4.beacon.model.exception.ValidationException;
/*     */ import me.appz4.beacon.model.model.Position;
/*     */ import me.appz4.beacon.model.validator.IRequestValidator;
/*     */ import me.appz4.beacon.model.validator.ValidatorUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreateBeaconRequest
/*     */   extends ApiRequestWithToken
/*     */   implements IRequestValidator
/*     */ {
/*     */   private Long beaconFactoryTypeId;
/*     */   private String factoryId;
/*     */   private Position position;
/*     */   private String name;
/*     */   private String desc;
/*     */   private String type;
/*     */   private String iconType;
/*     */   private String phone;
/*     */   
/*     */   public Long getBeaconFactoryTypeId()
/*     */   {
/*  29 */     return this.beaconFactoryTypeId;
/*     */   }
/*     */   
/*     */   public void setBeaconFactoryTypeId(Long beaconFactoryTypeId) {
/*  33 */     this.beaconFactoryTypeId = beaconFactoryTypeId;
/*     */   }
/*     */   
/*     */   public String getFactoryId() {
/*  37 */     return this.factoryId;
/*     */   }
/*     */   
/*     */   public void setFactoryId(String factoryId) {
/*  41 */     this.factoryId = factoryId;
/*     */   }
/*     */   
/*     */   public Position getPosition() {
/*  45 */     return this.position;
/*     */   }
/*     */   
/*     */   public void setPosition(Position position) {
/*  49 */     this.position = position;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  57 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getDesc() {
/*  61 */     return this.desc;
/*     */   }
/*     */   
/*     */   public void setDesc(String desc) {
/*  65 */     this.desc = desc;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  69 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  73 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getIconType() {
/*  77 */     return this.iconType;
/*     */   }
/*     */   
/*     */   public void setIconType(String iconType) {
/*  81 */     this.iconType = iconType;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  85 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  89 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  94 */     return "CreateBeaconRequest [factoryId=" + this.factoryId + ", position=" + this.position + ", name=" + this.name + ", desc=" + this.desc + ", type=" + this.type + ", phone=" + this.phone + "]";
/*     */   }
/*     */   
/*     */   public boolean onValidate()
/*     */     throws ValidationException
/*     */   {
/* 100 */     ValidatorUtils.isNull(this.beaconFactoryTypeId, "beaconFactoryTypeId");
/* 101 */     if (!ValidatorUtils.hasText(this.factoryId)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "factoryId" });
/* 102 */     if (!ValidatorUtils.hasText(this.name)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "name" });
/* 103 */     if (!ValidatorUtils.hasText(this.desc)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "description" });
/* 104 */     if (!ValidatorUtils.hasText(this.type)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "type" });
/* 105 */     if (!ValidatorUtils.hasText(this.iconType)) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "iconType" });
/* 106 */     if (this.position == null) { throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "position" });
/*     */     }
/* 108 */     if (this.position.getLatitude() == null) throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "latitude" });
/* 109 */     if (this.position.getLongitude() == null) { throw new ValidationException(Errors.ERROR_PARAMETER, new String[] { "longitude" });
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\api\request\beacon\CreateBeaconRequest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */