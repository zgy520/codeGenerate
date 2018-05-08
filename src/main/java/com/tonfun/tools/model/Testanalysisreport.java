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
  @NotNull
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
}
