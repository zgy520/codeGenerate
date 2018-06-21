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
@Table(name="testanalysisdetail")
//对应的表为:testanalysisdetail
public class Testanalysisdetail{
  private static final Logger LOGGER = LoggerFactory.getLogger(Testanalysisdetail.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long reportID;
  //varchar(50) 
  @NotNull
  private String itemName;
  //varchar(50) 
  @NotNull
  private String qualityTarget;
  //varchar(255) 
  private String testResult;
  //varchar(50) 
  @NotNull
  private String testMethod;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setReportID(Long reportID){
    this.reportID = reportID;
  }


  public Long getReportID(){
    return this.reportID;
  }


  public void setItemName(String itemName){
    this.itemName = itemName;
  }


  public String getItemName(){
    return this.itemName;
  }


  public void setQualityTarget(String qualityTarget){
    this.qualityTarget = qualityTarget;
  }


  public String getQualityTarget(){
    return this.qualityTarget;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }


  public void setTestMethod(String testMethod){
    this.testMethod = testMethod;
  }


  public String getTestMethod(){
    return this.testMethod;
  }
  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,reportID=%s,itemName=%s,qualityTarget=%s,testResult=%s,testMethod=%s",this.recordID,this.reportID,this.itemName,this.qualityTarget,this.testResult,this.testMethod);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_REPORTID="reportID";
  public static String getFieldreportID() {
    return FIELD_REPORTID;
  }

  private final static String FIELD_ITEMNAME="itemName";
  public static String getFielditemName() {
    return FIELD_ITEMNAME;
  }

  private final static String FIELD_QUALITYTARGET="qualityTarget";
  public static String getFieldqualityTarget() {
    return FIELD_QUALITYTARGET;
  }

  private final static String FIELD_TESTRESULT="testResult";
  public static String getFieldtestResult() {
    return FIELD_TESTRESULT;
  }

  private final static String FIELD_TESTMETHOD="testMethod";
  public static String getFieldtestMethod() {
    return FIELD_TESTMETHOD;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Testanalysisdetail)) return false;
    Testanalysisdetail testanalysisdetail= (Testanalysisdetail)o;
    return recordID!= null && recordID.equals(testanalysisdetail.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
