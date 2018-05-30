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
@Table(name="densityrecord")
//对应的表为:densityrecord
public class Densityrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //float 
  private float averageValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "densityrecord")
  private Set<Densitysample>  densitysamples = new HashSet<>();

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
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

  public Set<Densitysample> getDensitysample() {
    return this.densitysamples;
  }

  public void setDensitysample(Set<Densitysample> densitysamples) {
    this.densitysamples = densitysamples;
  }

  @Override
  public String toString() {
    return String.format("recordID=%s,averageValue=%s",this.recordID,this.averageValue);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_AVERAGEVALUE="averageValue";
  public static String getFieldaverageValue() {
    return FIELD_AVERAGEVALUE;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Densityrecord)) return false;
    Densityrecord densityrecord= (Densityrecord)o;
    return recordID!= null && recordID.equals(densityrecord.recordID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
