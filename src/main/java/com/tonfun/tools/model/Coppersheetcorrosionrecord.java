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
@Table(name="coppersheetcorrosionrecord")
//对应的表为:coppersheetcorrosionrecord
public class Coppersheetcorrosionrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //int(11) 
  @NotNull
  private int temperature;
  //time 
  @NotNull
  private LocalTime endTime;
  //time 
  @NotNull
  private LocalTime startTime;
  //varchar(50) 
  @NotNull
  private String testResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

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


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }


  public void setEndTime(LocalTime endTime){
    this.endTime = endTime;
  }


  public LocalTime getEndTime(){
    return this.endTime;
  }


  public void setStartTime(LocalTime startTime){
    this.startTime = startTime;
  }


  public LocalTime getStartTime(){
    return this.startTime;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

}
