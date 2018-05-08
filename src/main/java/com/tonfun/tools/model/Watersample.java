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
@Table(name="watersample")
//对应的表为:watersample
public class Watersample{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //bigint(20) 
  @NotNull
  private Long recordID;
  //int(11) 
  @NotNull
  private int sampleNo;
  //float 
  @NotNull
  private float sampleQuality;
  //time 
  private LocalTime startTime;
  //time 
  private LocalTime endTime;
  //float 
  private float waterVolume;
  //varchar(50) 
  private String testResult;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setSampleID(Long sampleID){
    this.sampleID = sampleID;
  }


  public Long getSampleID(){
    return this.sampleID;
  }


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setSampleNo(int sampleNo){
    this.sampleNo = sampleNo;
  }


  public int getSampleNo(){
    return this.sampleNo;
  }


  public void setSampleQuality(float sampleQuality){
    this.sampleQuality = sampleQuality;
  }


  public float getSampleQuality(){
    return this.sampleQuality;
  }


  public void setStartTime(LocalTime startTime){
    this.startTime = startTime;
  }


  public LocalTime getStartTime(){
    return this.startTime;
  }


  public void setEndTime(LocalTime endTime){
    this.endTime = endTime;
  }


  public LocalTime getEndTime(){
    return this.endTime;
  }


  public void setWaterVolume(float waterVolume){
    this.waterVolume = waterVolume;
  }


  public float getWaterVolume(){
    return this.waterVolume;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
}
