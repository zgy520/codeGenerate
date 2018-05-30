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
@Table(name="alkalivaluesample")
//对应的表为:alkalivaluesample
public class Alkalivaluesample{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //int(11) 
  @NotNull
  private int sampleNo;
  //float 
  @NotNull
  private float sampleQuality;
  //float 
  @NotNull
  private float computResult;
  //float 
  @NotNull
  private float solutionVolume;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  private Alkalivaluerecord  alkalivaluerecord;

  //关系实体创建完毕


  public void setSampleID(Long sampleID){
    this.sampleID = sampleID;
  }


  public Long getSampleID(){
    return this.sampleID;
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


  public void setComputResult(float computResult){
    this.computResult = computResult;
  }


  public float getComputResult(){
    return this.computResult;
  }


  public void setSolutionVolume(float solutionVolume){
    this.solutionVolume = solutionVolume;
  }


  public float getSolutionVolume(){
    return this.solutionVolume;
  }
  public Alkalivaluerecord getAlkalivaluerecord() {
    return this.alkalivaluerecord;
  }

  public void setAlkalivaluerecord(Alkalivaluerecord alkalivaluerecord) {
    this.alkalivaluerecord = alkalivaluerecord;
  }

  @Override
  public String toString() {
    return String.format("sampleID=%s,sampleNo=%s,sampleQuality=%s,computResult=%s,solutionVolume=%s",this.sampleID,this.sampleNo,this.sampleQuality,this.computResult,this.solutionVolume);
  }
  private final static String FIELD_SAMPLEID="sampleID";
  public static String getFieldsampleID() {
    return FIELD_SAMPLEID;
  }

  private final static String FIELD_SAMPLENO="sampleNo";
  public static String getFieldsampleNo() {
    return FIELD_SAMPLENO;
  }

  private final static String FIELD_SAMPLEQUALITY="sampleQuality";
  public static String getFieldsampleQuality() {
    return FIELD_SAMPLEQUALITY;
  }

  private final static String FIELD_COMPUTRESULT="computResult";
  public static String getFieldcomputResult() {
    return FIELD_COMPUTRESULT;
  }

  private final static String FIELD_SOLUTIONVOLUME="solutionVolume";
  public static String getFieldsolutionVolume() {
    return FIELD_SOLUTIONVOLUME;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Alkalivaluesample)) return false;
    Alkalivaluesample alkalivaluesample= (Alkalivaluesample)o;
    return sampleID!= null && sampleID.equals(alkalivaluesample.sampleID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
