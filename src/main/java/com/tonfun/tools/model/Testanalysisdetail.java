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
@Table(name="testanalysisdetail")
//对应的表为:testanalysisdetail
public class Testanalysisdetail{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long reportID;
  //varchar(50) 
  @NotNull
  private String itemName;
  //varchar(50) 
  @NotNull
  private String qualityTarget;
  //varchar(255) 
  private String testResult;
  //varchar(50) 
  @NotNull
  private String testMethod;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setReportID(Long reportID){
    this.reportID = reportID;
  }


  public Long getReportID(){
    return this.reportID;
  }


  public void setItemName(String itemName){
    this.itemName = itemName;
  }


  public String getItemName(){
    return this.itemName;
  }


  public void setQualityTarget(String qualityTarget){
    this.qualityTarget = qualityTarget;
  }


  public String getQualityTarget(){
    return this.qualityTarget;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }


  public void setTestMethod(String testMethod){
    this.testMethod = testMethod;
  }


  public String getTestMethod(){
    return this.testMethod;
  }
}
