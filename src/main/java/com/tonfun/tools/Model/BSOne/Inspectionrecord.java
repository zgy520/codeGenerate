package com.tonfun.tools.Model.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import com.tonfun.tools.Auditing.hibernate.AuditListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.EntityListeners;





@Entity
@EntityListeners(AuditListener.class)
@Table(name="inspectionrecord")
//对应的表为:inspectionrecord
public class Inspectionrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Inspectionrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long inspOrderID;
  //varchar(255) 
  @NotNull
  private String orderNo;
  //varchar(255) 
  @NotNull
  private String sampleName;
  //varchar(255) 
  @NotNull
  private String sampleModel;
  //varchar(255) 
  private String imgPath;
  //int(255) 
  private int sampleNo;
  //varchar(255) 
  @NotNull
  private String sampleSpot;
  //date 
  @NotNull
  private LocalDate sampleDate;
  //int(255) 
  private int batch;
  //varchar(20) 
  private String exterior;
  //float 
  private float chroma;
  //varchar(20) 
  private String analyst;
  //date 
  private LocalDate analysisDate;
  //varchar(20) 
  private String auditor;
  //datetime 
  private LocalDateTime auditedTime;
  //tinyint(1) 是否生成报名
  @NotNull
  private int visible;
  //varchar(20) 
  @NotNull
  private String creator;
  //datetime 
  private LocalDateTime createTime;
  //varchar(20) 
  private String updator;
  //datetime 
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productionOrderID")
  @JsonIgnore
  private Productionorder  productionorder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  @JsonIgnore
  private Inspectionclass  inspectionclass;

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Flashrecord>  flashrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Kinematicviscosityrecord>  kinematicviscosityrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Densityrecord>  densityrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Demulsifyrecord>  demulsifyrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Mechanicalimpuritiesrecord>  mechanicalimpuritiesrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Foamrecord>  foamrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Pourpointrecord>  pourpointrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Alkalivaluerecord>  alkalivaluerecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Coppersheetcorrosionrecord>  coppersheetcorrosionrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  @JsonIgnore
  private Set<Acidvaluerecord>  acidvaluerecords = new HashSet<>();

  //关系实体创建完毕


  public void setInspOrderID(Long inspOrderID){
    this.inspOrderID = inspOrderID;
  }


  public Long getInspOrderID(){
    return this.inspOrderID;
  }


  public void setOrderNo(String orderNo){
    this.orderNo = orderNo;
  }


  public String getOrderNo(){
    return this.orderNo;
  }


  public void setSampleName(String sampleName){
    this.sampleName = sampleName;
  }


  public String getSampleName(){
    return this.sampleName;
  }


  public void setSampleModel(String sampleModel){
    this.sampleModel = sampleModel;
  }


  public String getSampleModel(){
    return this.sampleModel;
  }


  public void setImgPath(String imgPath){
    this.imgPath = imgPath;
  }


  public String getImgPath(){
    return this.imgPath;
  }


  public void setSampleNo(int sampleNo){
    this.sampleNo = sampleNo;
  }


  public int getSampleNo(){
    return this.sampleNo;
  }


  public void setSampleSpot(String sampleSpot){
    this.sampleSpot = sampleSpot;
  }


  public String getSampleSpot(){
    return this.sampleSpot;
  }


  public void setSampleDate(LocalDate sampleDate){
    this.sampleDate = sampleDate;
  }


  public LocalDate getSampleDate(){
    return this.sampleDate;
  }


  public void setBatch(int batch){
    this.batch = batch;
  }


  public int getBatch(){
    return this.batch;
  }


  public void setExterior(String exterior){
    this.exterior = exterior;
  }


  public String getExterior(){
    return this.exterior;
  }


  public void setChroma(float chroma){
    this.chroma = chroma;
  }


  public float getChroma(){
    return this.chroma;
  }


  public void setAnalyst(String analyst){
    this.analyst = analyst;
  }


  public String getAnalyst(){
    return this.analyst;
  }


  public void setAnalysisDate(LocalDate analysisDate){
    this.analysisDate = analysisDate;
  }


  public LocalDate getAnalysisDate(){
    return this.analysisDate;
  }


  public void setAuditor(String auditor){
    this.auditor = auditor;
  }


  public String getAuditor(){
    return this.auditor;
  }


  public void setAuditedTime(LocalDateTime auditedTime){
    this.auditedTime = auditedTime;
  }


  public LocalDateTime getAuditedTime(){
    return this.auditedTime;
  }


  public void setVisible(int visible){
    this.visible = visible;
  }


  public int getVisible(){
    return this.visible;
  }


  public void setCreator(String creator){
    this.creator = creator;
  }


  public String getCreator(){
    return this.creator;
  }


  public void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
  }


  public LocalDateTime getCreateTime(){
    return this.createTime;
  }


  public void setUpdator(String updator){
    this.updator = updator;
  }


  public String getUpdator(){
    return this.updator;
  }


  public void setUpdateTime(LocalDateTime updateTime){
    this.updateTime = updateTime;
  }


  public LocalDateTime getUpdateTime(){
    return this.updateTime;
  }
  public Productionorder getProductionorder() {
    return this.productionorder;
  }

  public void setProductionorder(Productionorder productionorder) {
    this.productionorder = productionorder;
  }

  public Inspectionclass getInspectionclass() {
    return this.inspectionclass;
  }

  public void setInspectionclass(Inspectionclass inspectionclass) {
    this.inspectionclass = inspectionclass;
  }

  public Set<Flashrecord> getFlashrecord() {
    return this.flashrecords;
  }

  public void setFlashrecord(Set<Flashrecord> flashrecords) {
    this.flashrecords = flashrecords;
  }

  public Set<Kinematicviscosityrecord> getKinematicviscosityrecord() {
    return this.kinematicviscosityrecords;
  }

  public void setKinematicviscosityrecord(Set<Kinematicviscosityrecord> kinematicviscosityrecords) {
    this.kinematicviscosityrecords = kinematicviscosityrecords;
  }

  public Set<Densityrecord> getDensityrecord() {
    return this.densityrecords;
  }

  public void setDensityrecord(Set<Densityrecord> densityrecords) {
    this.densityrecords = densityrecords;
  }

  public Set<Demulsifyrecord> getDemulsifyrecord() {
    return this.demulsifyrecords;
  }

  public void setDemulsifyrecord(Set<Demulsifyrecord> demulsifyrecords) {
    this.demulsifyrecords = demulsifyrecords;
  }

  public Set<Mechanicalimpuritiesrecord> getMechanicalimpuritiesrecord() {
    return this.mechanicalimpuritiesrecords;
  }

  public void setMechanicalimpuritiesrecord(Set<Mechanicalimpuritiesrecord> mechanicalimpuritiesrecords) {
    this.mechanicalimpuritiesrecords = mechanicalimpuritiesrecords;
  }

  public Set<Foamrecord> getFoamrecord() {
    return this.foamrecords;
  }

  public void setFoamrecord(Set<Foamrecord> foamrecords) {
    this.foamrecords = foamrecords;
  }

  public Set<Pourpointrecord> getPourpointrecord() {
    return this.pourpointrecords;
  }

  public void setPourpointrecord(Set<Pourpointrecord> pourpointrecords) {
    this.pourpointrecords = pourpointrecords;
  }

  public Set<Alkalivaluerecord> getAlkalivaluerecord() {
    return this.alkalivaluerecords;
  }

  public void setAlkalivaluerecord(Set<Alkalivaluerecord> alkalivaluerecords) {
    this.alkalivaluerecords = alkalivaluerecords;
  }

  public Set<Coppersheetcorrosionrecord> getCoppersheetcorrosionrecord() {
    return this.coppersheetcorrosionrecords;
  }

  public void setCoppersheetcorrosionrecord(Set<Coppersheetcorrosionrecord> coppersheetcorrosionrecords) {
    this.coppersheetcorrosionrecords = coppersheetcorrosionrecords;
  }

  public Set<Acidvaluerecord> getAcidvaluerecord() {
    return this.acidvaluerecords;
  }

  public void setAcidvaluerecord(Set<Acidvaluerecord> acidvaluerecords) {
    this.acidvaluerecords = acidvaluerecords;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("inspOrderID=%s,orderNo=%s,sampleName=%s,sampleModel=%s,imgPath=%s,sampleNo=%s,sampleSpot=%s,sampleDate=%s,batch=%s,exterior=%s,chroma=%s,analyst=%s,analysisDate=%s,auditor=%s,auditedTime=%s,visible=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.inspOrderID,this.orderNo,this.sampleName,this.sampleModel,this.imgPath,this.sampleNo,this.sampleSpot,this.sampleDate,this.batch,this.exterior,this.chroma,this.analyst,this.analysisDate,this.auditor,this.auditedTime,this.visible,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_INSPORDERID="inspOrderID";
  public static String getFieldinspOrderID() {
    return FIELD_INSPORDERID;
  }

  private final static String FIELD_ORDERNO="orderNo";
  public static String getFieldorderNo() {
    return FIELD_ORDERNO;
  }

  private final static String FIELD_SAMPLENAME="sampleName";
  public static String getFieldsampleName() {
    return FIELD_SAMPLENAME;
  }

  private final static String FIELD_SAMPLEMODEL="sampleModel";
  public static String getFieldsampleModel() {
    return FIELD_SAMPLEMODEL;
  }

  private final static String FIELD_IMGPATH="imgPath";
  public static String getFieldimgPath() {
    return FIELD_IMGPATH;
  }

  private final static String FIELD_SAMPLENO="sampleNo";
  public static String getFieldsampleNo() {
    return FIELD_SAMPLENO;
  }

  private final static String FIELD_SAMPLESPOT="sampleSpot";
  public static String getFieldsampleSpot() {
    return FIELD_SAMPLESPOT;
  }

  private final static String FIELD_SAMPLEDATE="sampleDate";
  public static String getFieldsampleDate() {
    return FIELD_SAMPLEDATE;
  }

  private final static String FIELD_BATCH="batch";
  public static String getFieldbatch() {
    return FIELD_BATCH;
  }

  private final static String FIELD_EXTERIOR="exterior";
  public static String getFieldexterior() {
    return FIELD_EXTERIOR;
  }

  private final static String FIELD_CHROMA="chroma";
  public static String getFieldchroma() {
    return FIELD_CHROMA;
  }

  private final static String FIELD_ANALYST="analyst";
  public static String getFieldanalyst() {
    return FIELD_ANALYST;
  }

  private final static String FIELD_ANALYSISDATE="analysisDate";
  public static String getFieldanalysisDate() {
    return FIELD_ANALYSISDATE;
  }

  private final static String FIELD_AUDITOR="auditor";
  public static String getFieldauditor() {
    return FIELD_AUDITOR;
  }

  private final static String FIELD_AUDITEDTIME="auditedTime";
  public static String getFieldauditedTime() {
    return FIELD_AUDITEDTIME;
  }

  private final static String FIELD_VISIBLE="visible";
  public static String getFieldvisible() {
    return FIELD_VISIBLE;
  }

  private final static String FIELD_CREATOR="creator";
  public static String getFieldcreator() {
    return FIELD_CREATOR;
  }

  private final static String FIELD_CREATETIME="createTime";
  public static String getFieldcreateTime() {
    return FIELD_CREATETIME;
  }

  private final static String FIELD_UPDATOR="updator";
  public static String getFieldupdator() {
    return FIELD_UPDATOR;
  }

  private final static String FIELD_UPDATETIME="updateTime";
  public static String getFieldupdateTime() {
    return FIELD_UPDATETIME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Inspectionrecord)) return false;
    Inspectionrecord inspectionrecord= (Inspectionrecord)o;
    return inspOrderID!= null && inspOrderID.equals(inspectionrecord.inspOrderID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
