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
  @Override
  public String toString() {
    return String.format("sampleID=%s,recordID=%s,sampleNo=%s,sampleQuality=%s,startTime=%s,endTime=%s,waterVolume=%s,testResult=%s",this.sampleID,this.recordID,this.sampleNo,this.sampleQuality,this.startTime,this.endTime,this.waterVolume,this.testResult);
  }
  private final static String FIELD_SAMPLEID="sampleID";
  public static String getFieldsampleID() {
    return FIELD_SAMPLEID;
  }

  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_SAMPLENO="sampleNo";
  public static String getFieldsampleNo() {
    return FIELD_SAMPLENO;
  }

  private final static String FIELD_SAMPLEQUALITY="sampleQuality";
  public static String getFieldsampleQuality() {
    return FIELD_SAMPLEQUALITY;
  }

  private final static String FIELD_STARTTIME="startTime";
  public static String getFieldstartTime() {
    return FIELD_STARTTIME;
  }

  private final static String FIELD_ENDTIME="endTime";
  public static String getFieldendTime() {
    return FIELD_ENDTIME;
  }

  private final static String FIELD_WATERVOLUME="waterVolume";
  public static String getFieldwaterVolume() {
    return FIELD_WATERVOLUME;
  }

  private final static String FIELD_TESTRESULT="testResult";
  public static String getFieldtestResult() {
    return FIELD_TESTRESULT;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Watersample)) return false;
    Watersample watersample= (Watersample)o;
    return sampleID!= null && sampleID.equals(watersample.sampleID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
