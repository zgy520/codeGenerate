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
@Table(name="pourpointrecord")
//对应的表为:pourpointrecord
public class Pourpointrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
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

  @Override
  public String toString() {
    return String.format("recordID=%s,thermometerNo=%s,adjustedValue=%s,pourPointResult=%s",this.recordID,this.thermometerNo,this.adjustedValue,this.pourPointResult);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_THERMOMETERNO="thermometerNo";
  public static String getFieldthermometerNo() {
    return FIELD_THERMOMETERNO;
  }

  private final static String FIELD_ADJUSTEDVALUE="adjustedValue";
  public static String getFieldadjustedValue() {
    return FIELD_ADJUSTEDVALUE;
  }

  private final static String FIELD_POURPOINTRESULT="pourPointResult";
  public static String getFieldpourPointResult() {
    return FIELD_POURPOINTRESULT;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Pourpointrecord)) return false;
    Pourpointrecord pourpointrecord= (Pourpointrecord)o;
    return recordID!= null && recordID.equals(pourpointrecord.recordID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
