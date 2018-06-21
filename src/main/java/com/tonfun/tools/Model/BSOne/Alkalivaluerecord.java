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
@Table(name="alkalivaluerecord")
//对应的表为:alkalivaluerecord
public class Alkalivaluerecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Alkalivaluerecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //float 
  @NotNull
  private float CHCL;
  //float 
  private float averageValue;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  @JsonIgnore
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "alkalivaluerecord")
  @JsonIgnore
  private Set<Alkalivaluesample>  alkalivaluesamples = new HashSet<>();

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setCHCL(float CHCL){
    this.CHCL = CHCL;
  }


  public float getCHCL(){
    return this.CHCL;
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

  public Set<Alkalivaluesample> getAlkalivaluesample() {
    return this.alkalivaluesamples;
  }

  public void setAlkalivaluesample(Set<Alkalivaluesample> alkalivaluesamples) {
    this.alkalivaluesamples = alkalivaluesamples;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,CHCL=%s,averageValue=%s",this.recordID,this.CHCL,this.averageValue);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_CHCL="CHCL";
  public static String getFieldCHCL() {
    return FIELD_CHCL;
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
    if(!(o instanceof Alkalivaluerecord)) return false;
    Alkalivaluerecord alkalivaluerecord= (Alkalivaluerecord)o;
    return recordID!= null && recordID.equals(alkalivaluerecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
