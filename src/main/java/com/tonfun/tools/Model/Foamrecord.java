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
@Table(name="foamrecord")
//对应的表为:foamrecord
public class Foamrecord{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //varchar(10) 
  private String recordValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  private Inspectionrecord  inspectionrecord;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "itemID")
  private Foamitem  foamitem;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setRecordValue(String recordValue){
    this.recordValue = recordValue;
  }


  public String getRecordValue(){
    return this.recordValue;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  public Foamitem getFoamitem() {
    return this.foamitem;
  }

  public void setFoamitem(Foamitem foamitem) {
    this.foamitem = foamitem;
  }

  @Override
  public String toString() {
    return String.format("recordID=%s,recordValue=%s",this.recordID,this.recordValue);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_RECORDVALUE="recordValue";
  public static String getFieldrecordValue() {
    return FIELD_RECORDVALUE;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Foamrecord)) return false;
    Foamrecord foamrecord= (Foamrecord)o;
    return recordID!= null && recordID.equals(foamrecord.recordID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
