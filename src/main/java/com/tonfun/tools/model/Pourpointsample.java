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
@Table(name="pourpointsample")
//对应的表为:pourpointsample
public class Pourpointsample{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //bigint(20) 
  @NotNull
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long classID;
  //int(11) 
  @NotNull
  private int temperature;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  private Pourpointclass  pourpointclass;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  private Pourpointrecord  pourpointrecord;

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


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }
  public Pourpointclass getPourpointclass() {
    return this.pourpointclass;
  }

  public void setPourpointclass(Pourpointclass pourpointclass) {
    this.pourpointclass = pourpointclass;
  }

  public Pourpointrecord getPourpointrecord() {
    return this.pourpointrecord;
  }

  public void setPourpointrecord(Pourpointrecord pourpointrecord) {
    this.pourpointrecord = pourpointrecord;
  }

}
