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
@Table(name="acidvaluesample")
//对应的表为:acidvaluesample
public class Acidvaluesample{
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
  //float 
  @NotNull
  private float solutionVolume;
  //float 
  @NotNull
  private float computResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  private Acidvaluerecord  acidvaluerecord;

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


  public void setSolutionVolume(float solutionVolume){
    this.solutionVolume = solutionVolume;
  }


  public float getSolutionVolume(){
    return this.solutionVolume;
  }


  public void setComputResult(float computResult){
    this.computResult = computResult;
  }


  public float getComputResult(){
    return this.computResult;
  }
  public Acidvaluerecord getAcidvaluerecord() {
    return this.acidvaluerecord;
  }

  public void setAcidvaluerecord(Acidvaluerecord acidvaluerecord) {
    this.acidvaluerecord = acidvaluerecord;
  }

}
