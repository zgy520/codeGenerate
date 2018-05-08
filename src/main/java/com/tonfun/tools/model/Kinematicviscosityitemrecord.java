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
@Table(name="kinematicviscosityitemrecord")
//对应的表为:kinematicviscosityitemrecord
public class Kinematicviscosityitemrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long subjectID;
  //bigint(20) 
  @NotNull
  private Long recordID;
  //int(11) 
  @NotNull
  private int viscosityTubeNo;
  //int(11) 
  @NotNull
  private int temperature;
  //float 
  @NotNull
  private float ratio;
  //float 
  @NotNull
  private float averageValue;
  //varchar(50) 
  @NotNull
  private String testResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  private Kinematicviscosityrecord  kinematicviscosityrecord;

  @OneToMany(mappedBy = "kinematicviscosityitemrecord")
  private Set<Kinematicviscositysample>  kinematicviscositysamples = new HashSet<>();

  //关系实体创建完毕


  public void setSubjectID(Long subjectID){
    this.subjectID = subjectID;
  }


  public Long getSubjectID(){
    return this.subjectID;
  }


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setViscosityTubeNo(int viscosityTubeNo){
    this.viscosityTubeNo = viscosityTubeNo;
  }


  public int getViscosityTubeNo(){
    return this.viscosityTubeNo;
  }


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }


  public void setRatio(float ratio){
    this.ratio = ratio;
  }


  public float getRatio(){
    return this.ratio;
  }


  public void setAverageValue(float averageValue){
    this.averageValue = averageValue;
  }


  public float getAverageValue(){
    return this.averageValue;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
  public Kinematicviscosityrecord getKinematicviscosityrecord() {
    return this.kinematicviscosityrecord;
  }

  public void setKinematicviscosityrecord(Kinematicviscosityrecord kinematicviscosityrecord) {
    this.kinematicviscosityrecord = kinematicviscosityrecord;
  }

  public Set<Kinematicviscositysample> getKinematicviscositysample() {
    return this.kinematicviscositysamples;
  }

  public void setKinematicviscositysample(Set<Kinematicviscositysample> kinematicviscositysamples) {
    this.kinematicviscositysamples = kinematicviscositysamples;
  }

}
