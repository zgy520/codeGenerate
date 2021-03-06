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
@Table(name="flashrecord")
//对应的表为:flashrecord
public class Flashrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Flashrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //int(11) 
  @NotNull
  private int temperature;
  //float 
  private float atmos;
  //int(11) 
  private int flashResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  @JsonIgnore
  private Inspectionrecord  inspectionrecord;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }


  public void setAtmos(float atmos){
    this.atmos = atmos;
  }


  public float getAtmos(){
    return this.atmos;
  }


  public void setFlashResult(int flashResult){
    this.flashResult = flashResult;
  }


  public int getFlashResult(){
    return this.flashResult;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,temperature=%s,atmos=%s,flashResult=%s",this.recordID,this.temperature,this.atmos,this.flashResult);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_TEMPERATURE="temperature";
  public static String getFieldtemperature() {
    return FIELD_TEMPERATURE;
  }

  private final static String FIELD_ATMOS="atmos";
  public static String getFieldatmos() {
    return FIELD_ATMOS;
  }

  private final static String FIELD_FLASHRESULT="flashResult";
  public static String getFieldflashResult() {
    return FIELD_FLASHRESULT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Flashrecord)) return false;
    Flashrecord flashrecord= (Flashrecord)o;
    return recordID!= null && recordID.equals(flashrecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
