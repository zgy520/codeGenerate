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
@Table(name="acidvaluerecord")
//对应的表为:acidvaluerecord
public class Acidvaluerecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //float 
  @NotNull
  private float CNAOH;
  //float 
  private float averageValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "acidvaluerecord")
  private Set<Acidvaluesample>  acidvaluesamples = new HashSet<>();

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


  public void setCNAOH(float CNAOH){
    this.CNAOH = CNAOH;
  }


  public float getCNAOH(){
    return this.CNAOH;
  }


  public void setAverageValue(float averageValue){
    this.averageValue = averageValue;
  }


  public float getAverageValue(){
    return this.averageValue;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  public Set<Acidvaluesample> getAcidvaluesample() {
    return this.acidvaluesamples;
  }

  public void setAcidvaluesample(Set<Acidvaluesample> acidvaluesamples) {
    this.acidvaluesamples = acidvaluesamples;
  }

}
