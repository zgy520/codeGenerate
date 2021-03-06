package com.tonfun.tools.Model.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
import com.tonfun.tools.Auditing.hibernate.AuditListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.EntityListeners;





@Entity
@EntityListeners(AuditListener.class)
@Table(name="acidvaluesample")
//对应的表为:acidvaluesample
public class Acidvaluesample{
  private static final Logger LOGGER = LoggerFactory.getLogger(Acidvaluesample.class);
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
  private float solutionVolume;
  //float 
  @NotNull
  private float computResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  @JsonIgnore
  private Acidvaluerecord  acidvaluerecord;

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

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("sampleID=%s,sampleNo=%s,sampleQuality=%s,solutionVolume=%s,computResult=%s",this.sampleID,this.sampleNo,this.sampleQuality,this.solutionVolume,this.computResult);
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

  private final static String FIELD_SOLUTIONVOLUME="solutionVolume";
  public static String getFieldsolutionVolume() {
    return FIELD_SOLUTIONVOLUME;
  }

  private final static String FIELD_COMPUTRESULT="computResult";
  public static String getFieldcomputResult() {
    return FIELD_COMPUTRESULT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Acidvaluesample)) return false;
    Acidvaluesample acidvaluesample= (Acidvaluesample)o;
    return sampleID!= null && sampleID.equals(acidvaluesample.sampleID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
