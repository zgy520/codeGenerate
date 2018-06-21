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
@Table(name="waterrecord")
//对应的表为:waterrecord
public class Waterrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Waterrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //varchar(50) 
  private String testResult;
  //以下是对应的实体关系
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


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,inspOrderID=%s,testResult=%s",this.recordID,this.inspOrderID,this.testResult);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_INSPORDERID="inspOrderID";
  public static String getFieldinspOrderID() {
    return FIELD_INSPORDERID;
  }

  private final static String FIELD_TESTRESULT="testResult";
  public static String getFieldtestResult() {
    return FIELD_TESTRESULT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Waterrecord)) return false;
    Waterrecord waterrecord= (Waterrecord)o;
    return recordID!= null && recordID.equals(waterrecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
