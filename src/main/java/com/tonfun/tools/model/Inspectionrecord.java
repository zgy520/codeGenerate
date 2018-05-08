package com.tonfun.tools.model;


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





@Entity
@Table(name="inspectionrecord")
//对应的表为:inspectionrecord
public class Inspectionrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long inspOrderID;
  //bigint(20) 
  @NotNull
  private Long classID;
  //bigint(20) 
  private Long productionOrderID;
  //varchar(20) 
  @NotNull
  private String orderNo;
  //varchar(50) 
  @NotNull
  private String sampleName;
  //varchar(20) 
  @NotNull
  private String sampleModel;
  //varchar(255) 
  private String imgPath;
  //int(20) 
  private int sampleNo;
  //varchar(20) 
  @NotNull
  private String sampleSpot;
  //date 
  @NotNull
  private LocalDate sampleDate;
  //int(20) 
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
  @NotNull
  private LocalDateTime createTime;
  //varchar(20) 
  private String updator;
  //datetime 
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  private Inspectionclass  inspectionclass;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productionOrderID")
  private Productionorder  productionorder;

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Mechanicalimpuritiesrecord>  mechanicalimpuritiesrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Pourpointrecord>  pourpointrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Kinematicviscosityrecord>  kinematicviscosityrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Coppersheetcorrosionrecord>  coppersheetcorrosionrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Flashrecord>  flashrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Acidvaluerecord>  acidvaluerecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Demulsifyrecord>  demulsifyrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Alkalivaluerecord>  alkalivaluerecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Foamrecord>  foamrecords = new HashSet<>();

  @OneToMany(mappedBy = "inspectionrecord")
  private Set<Densityrecord>  densityrecords = new HashSet<>();

  //关系实体创建完毕


  public void setInspOrderID(Long inspOrderID){
    this.inspOrderID = inspOrderID;
  }


  public Long getInspOrderID(){
    return this.inspOrderID;
  }


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }


  public void setProductionOrderID(Long productionOrderID){
    this.productionOrderID = productionOrderID;
  }


  public Long getProductionOrderID(){
    return this.productionOrderID;
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
  public Inspectionclass getInspectionclass() {
    return this.inspectionclass;
  }

  public void setInspectionclass(Inspectionclass inspectionclass) {
    this.inspectionclass = inspectionclass;
  }

  public Productionorder getProductionorder() {
    return this.productionorder;
  }

  public void setProductionorder(Productionorder productionorder) {
    this.productionorder = productionorder;
  }

  public Set<Mechanicalimpuritiesrecord> getMechanicalimpuritiesrecord() {
    return this.mechanicalimpuritiesrecords;
  }

  public void setMechanicalimpuritiesrecord(Set<Mechanicalimpuritiesrecord> mechanicalimpuritiesrecords) {
    this.mechanicalimpuritiesrecords = mechanicalimpuritiesrecords;
  }

  public Set<Pourpointrecord> getPourpointrecord() {
    return this.pourpointrecords;
  }

  public void setPourpointrecord(Set<Pourpointrecord> pourpointrecords) {
    this.pourpointrecords = pourpointrecords;
  }

  public Set<Kinematicviscosityrecord> getKinematicviscosityrecord() {
    return this.kinematicviscosityrecords;
  }

  public void setKinematicviscosityrecord(Set<Kinematicviscosityrecord> kinematicviscosityrecords) {
    this.kinematicviscosityrecords = kinematicviscosityrecords;
  }

  public Set<Coppersheetcorrosionrecord> getCoppersheetcorrosionrecord() {
    return this.coppersheetcorrosionrecords;
  }

  public void setCoppersheetcorrosionrecord(Set<Coppersheetcorrosionrecord> coppersheetcorrosionrecords) {
    this.coppersheetcorrosionrecords = coppersheetcorrosionrecords;
  }

  public Set<Flashrecord> getFlashrecord() {
    return this.flashrecords;
  }

  public void setFlashrecord(Set<Flashrecord> flashrecords) {
    this.flashrecords = flashrecords;
  }

  public Set<Acidvaluerecord> getAcidvaluerecord() {
    return this.acidvaluerecords;
  }

  public void setAcidvaluerecord(Set<Acidvaluerecord> acidvaluerecords) {
    this.acidvaluerecords = acidvaluerecords;
  }

  public Set<Demulsifyrecord> getDemulsifyrecord() {
    return this.demulsifyrecords;
  }

  public void setDemulsifyrecord(Set<Demulsifyrecord> demulsifyrecords) {
    this.demulsifyrecords = demulsifyrecords;
  }

  public Set<Alkalivaluerecord> getAlkalivaluerecord() {
    return this.alkalivaluerecords;
  }

  public void setAlkalivaluerecord(Set<Alkalivaluerecord> alkalivaluerecords) {
    this.alkalivaluerecords = alkalivaluerecords;
  }

  public Set<Foamrecord> getFoamrecord() {
    return this.foamrecords;
  }

  public void setFoamrecord(Set<Foamrecord> foamrecords) {
    this.foamrecords = foamrecords;
  }

  public Set<Densityrecord> getDensityrecord() {
    return this.densityrecords;
  }

  public void setDensityrecord(Set<Densityrecord> densityrecords) {
    this.densityrecords = densityrecords;
  }

}
