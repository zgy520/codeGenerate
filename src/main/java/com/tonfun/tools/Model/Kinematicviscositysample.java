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
@Table(name="kinematicviscositysample")
//对应的表为:kinematicviscositysample
public class Kinematicviscositysample{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //int(11) 
  @NotNull
  private int sampleSerialNumber;
  //float 
  @NotNull
  private float viscosityValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subjectID")
  private Kinematicviscosityitemrecord  kinematicviscosityitemrecord;

  //关系实体创建完毕


  public void setSampleID(Long sampleID){
    this.sampleID = sampleID;
  }


  public Long getSampleID(){
    return this.sampleID;
  }


  public void setSampleSerialNumber(int sampleSerialNumber){
    this.sampleSerialNumber = sampleSerialNumber;
  }


  public int getSampleSerialNumber(){
    return this.sampleSerialNumber;
  }


  public void setViscosityValue(float viscosityValue){
    this.viscosityValue = viscosityValue;
  }


  public float getViscosityValue(){
    return this.viscosityValue;
  }
  public Kinematicviscosityitemrecord getKinematicviscosityitemrecord() {
    return this.kinematicviscosityitemrecord;
  }

  public void setKinematicviscosityitemrecord(Kinematicviscosityitemrecord kinematicviscosityitemrecord) {
    this.kinematicviscosityitemrecord = kinematicviscosityitemrecord;
  }

  @Override
  public String toString() {
    return String.format("sampleID=%s,sampleSerialNumber=%s,viscosityValue=%s",this.sampleID,this.sampleSerialNumber,this.viscosityValue);
  }
  private final static String FIELD_SAMPLEID="sampleID";
  public static String getFieldsampleID() {
    return FIELD_SAMPLEID;
  }

  private final static String FIELD_SAMPLESERIALNUMBER="sampleSerialNumber";
  public static String getFieldsampleSerialNumber() {
    return FIELD_SAMPLESERIALNUMBER;
  }

  private final static String FIELD_VISCOSITYVALUE="viscosityValue";
  public static String getFieldviscosityValue() {
    return FIELD_VISCOSITYVALUE;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Kinematicviscositysample)) return false;
    Kinematicviscositysample kinematicviscositysample= (Kinematicviscositysample)o;
    return sampleID!= null && sampleID.equals(kinematicviscositysample.sampleID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
