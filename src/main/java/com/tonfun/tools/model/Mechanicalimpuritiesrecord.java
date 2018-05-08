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
@Table(name="mechanicalimpuritiesrecord")
//对应的表为:mechanicalimpuritiesrecord
public class Mechanicalimpuritiesrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  private Long diluentID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //int(11) 
  @NotNull
  private int diluentDosage;
  //float 
  private float averageValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "diluentID")
  private Diluent  diluent;

  @OneToMany(mappedBy = "mechanicalimpuritiesrecord")
  private Set<Mechanicalimpuritiessample>  mechanicalimpuritiessamples = new HashSet<>();

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setDiluentID(Long diluentID){
    this.diluentID = diluentID;
  }


  public Long getDiluentID(){
    return this.diluentID;
  }


  public void setInspOrderID(Long inspOrderID){
    this.inspOrderID = inspOrderID;
  }


  public Long getInspOrderID(){
    return this.inspOrderID;
  }


  public void setDiluentDosage(int diluentDosage){
    this.diluentDosage = diluentDosage;
  }


  public int getDiluentDosage(){
    return this.diluentDosage;
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

  public Diluent getDiluent() {
    return this.diluent;
  }

  public void setDiluent(Diluent diluent) {
    this.diluent = diluent;
  }

  public Set<Mechanicalimpuritiessample> getMechanicalimpuritiessample() {
    return this.mechanicalimpuritiessamples;
  }

  public void setMechanicalimpuritiessample(Set<Mechanicalimpuritiessample> mechanicalimpuritiessamples) {
    this.mechanicalimpuritiessamples = mechanicalimpuritiessamples;
  }

}
