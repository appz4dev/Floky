/*     */ package me.appz4.beacon.model.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ import javax.persistence.*;
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="images")
/*     */ public class Image
/*     */ {
/*     */   public static final String ID = "id";
/*     */   public static final String NAME = "name";
/*     */   public static final String EXTENSION = "extension";
/*     */   public static final String TYPE = "type";
/*     */   public static final String CONNECTIONID = "connectionId";
/*     */   public static final String CONNECTIONTYPE = "connectionType";
/*     */   public static final String STATUS = "status";
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name="id")
/*     */   private Long id;
/*     */   @Column(name="name")
/*     */   private String name;
/*     */   @Column(name="extension")
/*     */   private String extension;
/*     */   @Column(name="size")
/*     */   private Integer size;
/*     */   @Column(name="url")
/*     */   private String url;

/*     */   @Column(name="type")
/*     */   private ImageType type;
/*     */   @Column(name="connectionId")
/*     */   private Long connectionId;
/*     */   @Column(name="connectionType")
/*     */   private ImageConnectionType connectionType;
/*     */   @Column(name="created")
/*     */   private Date created;
/*     */   @Column(name="status")
/*     */   private Integer status;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  59 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  63 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  67 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  71 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getExtension() {
/*  75 */     return this.extension;
/*     */   }
/*     */   
/*     */   public void setExtension(String extension) {
/*  79 */     this.extension = extension;
/*     */   }
/*     */   
/*     */   public Integer getSize() {
/*  83 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(Integer size) {
/*  87 */     this.size = size;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/*  91 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/*  95 */     this.url = url;
/*     */   }
/*     */   
/*     */   public ImageType getType() {
/*  99 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(ImageType type) {
/* 103 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Long getConnectionId() {
/* 107 */     return this.connectionId;
/*     */   }
/*     */   
/*     */   public void setConnectionId(Long connectionId) {
/* 111 */     this.connectionId = connectionId;
/*     */   }
/*     */   
/*     */   public ImageConnectionType getConnectionType() {
/* 115 */     return this.connectionType;
/*     */   }
/*     */   
/*     */   public void setConnectionType(ImageConnectionType connectionType) {
/* 119 */     this.connectionType = connectionType;
/*     */   }
/*     */   
/*     */   public Date getCreated() {
/* 123 */     return this.created;
/*     */   }
/*     */   
/*     */   public void setCreated(Date created) {
/* 127 */     this.created = created;
/*     */   }
/*     */   
/*     */   public Integer getStatus() {
/* 131 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(Integer status) {
/* 135 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 140 */     return "Image [id=" + this.id + ", name=" + this.name + ", extension=" + this.extension + ", size=" + this.size + ", url=" + this.url + ", type=" + this.type + ", connectionId=" + this.connectionId + ", connectionType=" + this.connectionType + ", created=" + this.created + ", status=" + this.status + "]";
/*     */   }
/*     */ }


/* Location:              D:\Downloads\beacon-model-1.1.4.jar!\me\appz4\beacon\model\model\Image.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */