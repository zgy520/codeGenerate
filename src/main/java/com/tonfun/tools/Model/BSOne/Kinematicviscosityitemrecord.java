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
@Table(name="kinematicviscosityitemrecord")
//对应的表为:kinematicviscosityitemrecord
public class Kinematicviscosityitemrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Kinematicviscosityitemrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long subjectID;
  //int(11) 
  @NotNull
  private int viscosityTubeNo;
  //int(11) 
  @NotNull
  private int temperature;
  //float 
  @NotNull
  private float ratio;
  //float 
  @NotNull
  private float averageValue;
  //varchar(50) 
  @NotNull
  private String testResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  @JsonIgnore
  private Kinematicviscosityrecord  kinematicviscosityrecord;

  @OneToMany(mappedBy = "kinematicviscosityitemrecord")
  @JsonIgnore
  private Set<Kinematicviscositysample>  kinematicviscositysamples = new HashSet<>();

  //关系实体创建完毕


  public void setSubjectID(Long subjectID){
    this.subjectID = subjectID;
  }


  public Long getSubjectID(){
    return this.subjectID;
  }


  public void setViscosityTubeNo(int viscosityTubeNo){
    this.viscosityTubeNo = viscosityTubeNo;
  }


  public int getViscosityTubeNo(){
    return this.viscosityTubeNo;
  }


  public void setTemperature(int temperature){
    this.temperature = temperature;
  }


  public int getTemperature(){
    return this.temperature;
  }


  public void setRatio(float ratio){
    this.ratio = ratio;
  }


  public float getRatio(){
    return this.ratio;
  }


  public void setAverageValue(float averageValue){
    this.averageValue = averageValue;
  }


  public float getAverageValue(){
    return this.averageValue;
  }


  public void setTestResult(String testResult){
    this.testResult = testResult;
  }


  public String getTestResult(){
    return this.testResult;
  }
  public Kinematicviscosityrecord getKinematicviscosityrecord() {
    return this.kinematicviscosityrecord;
  }

  public void setKinematicviscosityrecord(Kinematicviscosityrecord kinematicviscosityrecord) {
    this.kinematicviscosityrecord = kinematicviscosityrecord;
  }

  public Set<Kinematicviscositysample> getKinematicviscositysample() {
    return this.kinematicviscositysamples;
  }

  public void setKinematicviscositysample(Set<Kinematicviscositysample> kinematicviscositysamples) {
    this.kinematicviscositysamples = kinematicviscositysamples;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("subjectID=%s,viscosityTubeNo=%s,temperature=%s,ratio=%s,averageValue=%s,testResult=%s",this.subjectID,this.viscosityTubeNo,this.temperature,this.ratio,this.averageValue,this.testResult);
  }
  private final static String FIELD_SUBJECTID="subjectID";
  public static String getFieldsubjectID() {
    return FIELD_SUBJECTID;
  }

  private final static String FIELD_VISCOSITYTUBENO="viscosityTubeNo";
  public static String getFieldviscosityTubeNo() {
    return FIELD_VISCOSITYTUBENO;
  }

  private final static String FIELD_TEMPERATURE="temperature";
  public static String getFieldtemperature() {
    return FIELD_TEMPERATURE;
  }

  private final static String FIELD_RATIO="ratio";
  public static String getFieldratio() {
    return FIELD_RATIO;
  }

  private final static String FIELD_AVERAGEVALUE="averageValue";
  public static String getFieldaverageValue() {
    return FIELD_AVERAGEVALUE;
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
    if(!(o instanceof Kinematicviscosityitemrecord)) return false;
    Kinematicviscosityitemrecord kinematicviscosityitemrecord= (Kinematicviscosityitemrecord)o;
    return subjectID!= null && subjectID.equals(kinematicviscosityitemrecord.subjectID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
