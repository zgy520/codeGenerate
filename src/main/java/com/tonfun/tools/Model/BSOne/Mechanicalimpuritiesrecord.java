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
@Table(name="mechanicalimpuritiesrecord")
//对应的表为:mechanicalimpuritiesrecord
public class Mechanicalimpuritiesrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Mechanicalimpuritiesrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //int(11) 
  @NotNull
  private int diluentDosage;
  //float 
  private float averageValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "diluentID")
  @JsonIgnore
  private Diluent  diluent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  @JsonIgnore
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "mechanicalimpuritiesrecord")
  @JsonIgnore
  private Set<Mechanicalimpuritiessample>  mechanicalimpuritiessamples = new HashSet<>();

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
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
  public Diluent getDiluent() {
    return this.diluent;
  }

  public void setDiluent(Diluent diluent) {
    this.diluent = diluent;
  }

  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  public Set<Mechanicalimpuritiessample> getMechanicalimpuritiessample() {
    return this.mechanicalimpuritiessamples;
  }

  public void setMechanicalimpuritiessample(Set<Mechanicalimpuritiessample> mechanicalimpuritiessamples) {
    this.mechanicalimpuritiessamples = mechanicalimpuritiessamples;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,diluentDosage=%s,averageValue=%s",this.recordID,this.diluentDosage,this.averageValue);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_DILUENTDOSAGE="diluentDosage";
  public static String getFielddiluentDosage() {
    return FIELD_DILUENTDOSAGE;
  }

  private final static String FIELD_AVERAGEVALUE="averageValue";
  public static String getFieldaverageValue() {
    return FIELD_AVERAGEVALUE;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Mechanicalimpuritiesrecord)) return false;
    Mechanicalimpuritiesrecord mechanicalimpuritiesrecord= (Mechanicalimpuritiesrecord)o;
    return recordID!= null && recordID.equals(mechanicalimpuritiesrecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
