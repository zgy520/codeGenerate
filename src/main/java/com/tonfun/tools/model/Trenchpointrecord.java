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
@Table(name="trenchpointrecord")
//对应的表为:trenchpointrecord
public class Trenchpointrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //int(11) 
  private int bathTemperatureMin;
  //int(11) 
  private int bathTemperatureMax;
  //int(11) 
  private int coldBathTemperatureMin;
  //int(11) 
  private int coldBathTemperatureMax;
  //int(11) 
  private int sampleTempertureMin;
  //int(11) 
  private int sampleTempertureMax;
  //datetime 
  private LocalDateTime testStartTime;
  //datetime 
  private LocalDateTime testEndTime;
  //varchar(10) 
  private String sampleFlow;
  //varchar(50) 
  private String testResult;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setInspOrderID(Long inspOrderID){
    this.inspOrderID = inspOrderID;
  }


  public Long getInspOrderID(){
    return this.inspOrderID;
  }


  public void setBathTemperatureMin(int bathTemperatureMin){
    this.bathTemperatureMin = bathTemperatureMin;
  }


  public int getBathTemperatureMin(){
    return this.bathTemperatureMin;
  }


  public void setBathTemperatureMax(int bathTemperatureMax){
    this.bathTemperatureMax = bathTemperatureMax;
  }


  public int getBathTemperatureMax(){
    return this.bathTemperatureMax;
  }


  public void setColdBathTemperatureMin(int coldBathTemperatureMin){
    this.coldBathTemperatureMin = coldBathTemperatureMin;
  }


  public int getColdBathTemperatureMin(){
    return this.coldBathTemperatureMin;
  }


  public void setColdBathTemperatureMax(int coldBathTemperatureMax){
    this.coldBathTemperatureMax = coldBathTemperatureMax;
  }


  public int getColdBathTemperatureMax(){
    return this.coldBathTemperatureMax;
  }


  public void setSampleTempertureMin(int sampleTempertureMin){
    this.sampleTempertureMin = sampleTempertureMin;
  }


  public int getSampleTempertureMin(){
    return this.sampleTempertureMin;
  }


  public void setSampleTempertureMax(int sampleTempertureMax){
    this.sampleTempertureMax = sampleTempertureMax;
  }


  public int getSampleTempertureMax(){
    return this.sampleTempertureMax;
  }


  public void setTestStartTime(LocalDateTime testStartTime){
    this.testStartTime = testStartTime;
  }


  public LocalDateTime getTestStartTime(){
    return this.testStartTime;
  }


  public void setTestEndTime(LocalDateTime testEndTime){
    this.testEndTime = testEndTime;
  }


  public LocalDateTime getTestEndTime(){
    return this.testEndTime;
  }


  public void setSampleFlow(String sampleFlow){
    this.sampleFlow = sampleFlow;
  }


  public String getSampleFlow(){
    return this.sampleFlow;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
}
