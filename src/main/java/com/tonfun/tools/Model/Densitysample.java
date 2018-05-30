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
@Table(name="densitysample")
//对应的表为:densitysample
public class Densitysample{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //int(11) 
  @NotNull
  private int sampleNo;
  //int(11) 
  private int densimeterNo;
  //varchar(20) 
  private String thermometerNo;
  //int(11) 
  @NotNull
  private int temperature;
  //float 
  @NotNull
  private float apparentDensity;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  private Densityrecord  densityrecord;

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


  public void setDensimeterNo(int densimeterNo){
    this.densimeterNo = densimeterNo;
  }


  public int getDensimeterNo(){
    return this.densimeterNo;
  }


  public void setThermometerNo(String thermometerNo){
    this.thermometerNo = thermometerNo;
  }


  public String getThermometerNo(){
    return this.thermometerNo;
  }


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }


  public void setApparentDensity(float apparentDensity){
    this.apparentDensity = apparentDensity;
  }


  public float getApparentDensity(){
    return this.apparentDensity;
  }
  public Densityrecord getDensityrecord() {
    return this.densityrecord;
  }

  public void setDensityrecord(Densityrecord densityrecord) {
    this.densityrecord = densityrecord;
  }

  @Override
  public String toString() {
    return String.format("sampleID=%s,sampleNo=%s,densimeterNo=%s,thermometerNo=%s,temperature=%s,apparentDensity=%s",this.sampleID,this.sampleNo,this.densimeterNo,this.thermometerNo,this.temperature,this.apparentDensity);
  }
  private final static String FIELD_SAMPLEID="sampleID";
  public static String getFieldsampleID() {
    return FIELD_SAMPLEID;
  }

  private final static String FIELD_SAMPLENO="sampleNo";
  public static String getFieldsampleNo() {
    return FIELD_SAMPLENO;
  }

  private final static String FIELD_DENSIMETERNO="densimeterNo";
  public static String getFielddensimeterNo() {
    return FIELD_DENSIMETERNO;
  }

  private final static String FIELD_THERMOMETERNO="thermometerNo";
  public static String getFieldthermometerNo() {
    return FIELD_THERMOMETERNO;
  }

  private final static String FIELD_TEMPERATURE="temperature";
  public static String getFieldtemperature() {
    return FIELD_TEMPERATURE;
  }

  private final static String FIELD_APPARENTDENSITY="apparentDensity";
  public static String getFieldapparentDensity() {
    return FIELD_APPARENTDENSITY;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Densitysample)) return false;
    Densitysample densitysample= (Densitysample)o;
    return sampleID!= null && sampleID.equals(densitysample.sampleID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
