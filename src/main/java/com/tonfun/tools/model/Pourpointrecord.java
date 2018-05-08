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
@Table(name="pourpointrecord")
//对应的表为:pourpointrecord
public class Pourpointrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //varchar(20) 
  @NotNull
  private String thermometerNo;
  //int(11) 
  @NotNull
  private int adjustedValue;
  //int(11) 
  private int pourPointResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "pourpointrecord")
  private Set<Pourpointsample>  pourpointsamples = new HashSet<>();

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


  public void setThermometerNo(String thermometerNo){
    this.thermometerNo = thermometerNo;
  }


  public String getThermometerNo(){
    return this.thermometerNo;
  }


  public void setAdjustedValue(int adjustedValue){
    this.adjustedValue = adjustedValue;
  }


  public int getAdjustedValue(){
    return this.adjustedValue;
  }


  public void setPourPointResult(int pourPointResult){
    this.pourPointResult = pourPointResult;
  }


  public int getPourPointResult(){
    return this.pourPointResult;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  public Set<Pourpointsample> getPourpointsample() {
    return this.pourpointsamples;
  }

  public void setPourpointsample(Set<Pourpointsample> pourpointsamples) {
    this.pourpointsamples = pourpointsamples;
  }

}
