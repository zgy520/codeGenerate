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
@Table(name="trenchpointrecord")
//对应的表为:trenchpointrecord
public class Trenchpointrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Trenchpointrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long inspOrderID;
  //int(11) 
  private int bathTemperatureMin;
  //int(11) 
  private int bathTemperatureMax;
  //int(11) 
  private int coldBathTemperatureMin;
  //int(11) 
  private int coldBathTemperatureMax;
  //int(11) 
  private int sampleTempertureMin;
  //int(11) 
  private int sampleTempertureMax;
  //datetime 
  private LocalDateTime testStartTime;
  //datetime 
  private LocalDateTime testEndTime;
  //varchar(10) 
  private String sampleFlow;
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


  public void setBathTemperatureMin(int bathTemperatureMin){
    this.bathTemperatureMin = bathTemperatureMin;
  }


  public int getBathTemperatureMin(){
    return this.bathTemperatureMin;
  }


  public void setBathTemperatureMax(int bathTemperatureMax){
    this.bathTemperatureMax = bathTemperatureMax;
  }


  public int getBathTemperatureMax(){
    return this.bathTemperatureMax;
  }


  public void setColdBathTemperatureMin(int coldBathTemperatureMin){
    this.coldBathTemperatureMin = coldBathTemperatureMin;
  }


  public int getColdBathTemperatureMin(){
    return this.coldBathTemperatureMin;
  }


  public void setColdBathTemperatureMax(int coldBathTemperatureMax){
    this.coldBathTemperatureMax = coldBathTemperatureMax;
  }


  public int getColdBathTemperatureMax(){
    return this.coldBathTemperatureMax;
  }


  public void setSampleTempertureMin(int sampleTempertureMin){
    this.sampleTempertureMin = sampleTempertureMin;
  }


  public int getSampleTempertureMin(){
    return this.sampleTempertureMin;
  }


  public void setSampleTempertureMax(int sampleTempertureMax){
    this.sampleTempertureMax = sampleTempertureMax;
  }


  public int getSampleTempertureMax(){
    return this.sampleTempertureMax;
  }


  public void setTestStartTime(LocalDateTime testStartTime){
    this.testStartTime = testStartTime;
  }


  public LocalDateTime getTestStartTime(){
    return this.testStartTime;
  }


  public void setTestEndTime(LocalDateTime testEndTime){
    this.testEndTime = testEndTime;
  }


  public LocalDateTime getTestEndTime(){
    return this.testEndTime;
  }


  public void setSampleFlow(String sampleFlow){
    this.sampleFlow = sampleFlow;
  }


  public String getSampleFlow(){
    return this.sampleFlow;
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
    return String.format("recordID=%s,inspOrderID=%s,bathTemperatureMin=%s,bathTemperatureMax=%s,coldBathTemperatureMin=%s,coldBathTemperatureMax=%s,sampleTempertureMin=%s,sampleTempertureMax=%s,testStartTime=%s,testEndTime=%s,sampleFlow=%s,testResult=%s",this.recordID,this.inspOrderID,this.bathTemperatureMin,this.bathTemperatureMax,this.coldBathTemperatureMin,this.coldBathTemperatureMax,this.sampleTempertureMin,this.sampleTempertureMax,this.testStartTime,this.testEndTime,this.sampleFlow,this.testResult);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_INSPORDERID="inspOrderID";
  public static String getFieldinspOrderID() {
    return FIELD_INSPORDERID;
  }

  private final static String FIELD_BATHTEMPERATUREMIN="bathTemperatureMin";
  public static String getFieldbathTemperatureMin() {
    return FIELD_BATHTEMPERATUREMIN;
  }

  private final static String FIELD_BATHTEMPERATUREMAX="bathTemperatureMax";
  public static String getFieldbathTemperatureMax() {
    return FIELD_BATHTEMPERATUREMAX;
  }

  private final static String FIELD_COLDBATHTEMPERATUREMIN="coldBathTemperatureMin";
  public static String getFieldcoldBathTemperatureMin() {
    return FIELD_COLDBATHTEMPERATUREMIN;
  }

  private final static String FIELD_COLDBATHTEMPERATUREMAX="coldBathTemperatureMax";
  public static String getFieldcoldBathTemperatureMax() {
    return FIELD_COLDBATHTEMPERATUREMAX;
  }

  private final static String FIELD_SAMPLETEMPERTUREMIN="sampleTempertureMin";
  public static String getFieldsampleTempertureMin() {
    return FIELD_SAMPLETEMPERTUREMIN;
  }

  private final static String FIELD_SAMPLETEMPERTUREMAX="sampleTempertureMax";
  public static String getFieldsampleTempertureMax() {
    return FIELD_SAMPLETEMPERTUREMAX;
  }

  private final static String FIELD_TESTSTARTTIME="testStartTime";
  public static String getFieldtestStartTime() {
    return FIELD_TESTSTARTTIME;
  }

  private final static String FIELD_TESTENDTIME="testEndTime";
  public static String getFieldtestEndTime() {
    return FIELD_TESTENDTIME;
  }

  private final static String FIELD_SAMPLEFLOW="sampleFlow";
  public static String getFieldsampleFlow() {
    return FIELD_SAMPLEFLOW;
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
    if(!(o instanceof Trenchpointrecord)) return false;
    Trenchpointrecord trenchpointrecord= (Trenchpointrecord)o;
    return recordID!= null && recordID.equals(trenchpointrecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
