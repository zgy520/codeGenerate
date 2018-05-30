package com.tonfun.tools.Model;


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
@Table(name="testanalysisreport")
//对应的表为:testanalysisreport
public class Testanalysisreport{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long reportID;
  //bigint(20) 
  private Long productionOrderID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //bigint(20) 
  private Long conclusionID;
  //varchar(20) 
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
  private String analyst;
  //date 
  private LocalDate analysisDate;
  //varchar(20) 
  private String auditor;
  //datetime 
  private LocalDateTime auditedTime;
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
  //关系实体创建完毕


  public void setReportID(Long reportID){
    this.reportID = reportID;
  }


  public Long getReportID(){
    return this.reportID;
  }


  public void setProductionOrderID(Long productionOrderID){
    this.productionOrderID = productionOrderID;
  }


  public Long getProductionOrderID(){
    return this.productionOrderID;
  }


  public void setInspOrderID(Long inspOrderID){
    this.inspOrderID = inspOrderID;
  }


  public Long getInspOrderID(){
    return this.inspOrderID;
  }


  public void setConclusionID(Long conclusionID){
    this.conclusionID = conclusionID;
  }


  public Long getConclusionID(){
    return this.conclusionID;
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
  @Override
  public String toString() {
    return String.format("reportID=%s,productionOrderID=%s,inspOrderID=%s,conclusionID=%s,orderNo=%s,sampleName=%s,sampleModel=%s,imgPath=%s,sampleNo=%s,sampleSpot=%s,sampleDate=%s,batch=%s,analyst=%s,analysisDate=%s,auditor=%s,auditedTime=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.reportID,this.productionOrderID,this.inspOrderID,this.conclusionID,this.orderNo,this.sampleName,this.sampleModel,this.imgPath,this.sampleNo,this.sampleSpot,this.sampleDate,this.batch,this.analyst,this.analysisDate,this.auditor,this.auditedTime,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_REPORTID="reportID";
  public static String getFieldreportID() {
    return FIELD_REPORTID;
  }

  private final static String FIELD_PRODUCTIONORDERID="productionOrderID";
  public static String getFieldproductionOrderID() {
    return FIELD_PRODUCTIONORDERID;
  }

  private final static String FIELD_INSPORDERID="inspOrderID";
  public static String getFieldinspOrderID() {
    return FIELD_INSPORDERID;
  }

  private final static String FIELD_CONCLUSIONID="conclusionID";
  public static String getFieldconclusionID() {
    return FIELD_CONCLUSIONID;
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

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Testanalysisreport)) return false;
    Testanalysisreport testanalysisreport= (Testanalysisreport)o;
    return reportID!= null && reportID.equals(testanalysisreport.reportID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
