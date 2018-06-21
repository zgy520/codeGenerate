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
@Table(name="mechanicalimpuritiessample")
//对应的表为:mechanicalimpuritiessample
public class Mechanicalimpuritiessample{
  private static final Logger LOGGER = LoggerFactory.getLogger(Mechanicalimpuritiessample.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long sampleID;
  //int(11) 
  @NotNull
  private int sampleNo;
  //float 
  @NotNull
  private float sampleQuality;
  //float 
  @NotNull
  private float bottleFiterPaperImpurity;
  //float 
  @NotNull
  private float bottleFiterPaper;
  //float 
  private float impurity;
  //float 
  private float computResult;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "recordID")
  @JsonIgnore
  private Mechanicalimpuritiesrecord  mechanicalimpuritiesrecord;

  //关系实体创建完毕


  public void setSampleID(Long sampleID){
    this.sampleID = sampleID;
  }


  public Long getSampleID(){
    return this.sampleID;
  }


  public void setSampleNo(int sampleNo){
    this.sampleNo = sampleNo;
  }


  public int getSampleNo(){
    return this.sampleNo;
  }


  public void setSampleQuality(float sampleQuality){
    this.sampleQuality = sampleQuality;
  }


  public float getSampleQuality(){
    return this.sampleQuality;
  }


  public void setBottleFiterPaperImpurity(float bottleFiterPaperImpurity){
    this.bottleFiterPaperImpurity = bottleFiterPaperImpurity;
  }


  public float getBottleFiterPaperImpurity(){
    return this.bottleFiterPaperImpurity;
  }


  public void setBottleFiterPaper(float bottleFiterPaper){
    this.bottleFiterPaper = bottleFiterPaper;
  }


  public float getBottleFiterPaper(){
    return this.bottleFiterPaper;
  }


  public void setImpurity(float impurity){
    this.impurity = impurity;
  }


  public float getImpurity(){
    return this.impurity;
  }


  public void setComputResult(float computResult){
    this.computResult = computResult;
  }


  public float getComputResult(){
    return this.computResult;
  }
  public Mechanicalimpuritiesrecord getMechanicalimpuritiesrecord() {
    return this.mechanicalimpuritiesrecord;
  }

  public void setMechanicalimpuritiesrecord(Mechanicalimpuritiesrecord mechanicalimpuritiesrecord) {
    this.mechanicalimpuritiesrecord = mechanicalimpuritiesrecord;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("sampleID=%s,sampleNo=%s,sampleQuality=%s,bottleFiterPaperImpurity=%s,bottleFiterPaper=%s,impurity=%s,computResult=%s",this.sampleID,this.sampleNo,this.sampleQuality,this.bottleFiterPaperImpurity,this.bottleFiterPaper,this.impurity,this.computResult);
  }
  private final static String FIELD_SAMPLEID="sampleID";
  public static String getFieldsampleID() {
    return FIELD_SAMPLEID;
  }

  private final static String FIELD_SAMPLENO="sampleNo";
  public static String getFieldsampleNo() {
    return FIELD_SAMPLENO;
  }

  private final static String FIELD_SAMPLEQUALITY="sampleQuality";
  public static String getFieldsampleQuality() {
    return FIELD_SAMPLEQUALITY;
  }

  private final static String FIELD_BOTTLEFITERPAPERIMPURITY="bottleFiterPaperImpurity";
  public static String getFieldbottleFiterPaperImpurity() {
    return FIELD_BOTTLEFITERPAPERIMPURITY;
  }

  private final static String FIELD_BOTTLEFITERPAPER="bottleFiterPaper";
  public static String getFieldbottleFiterPaper() {
    return FIELD_BOTTLEFITERPAPER;
  }

  private final static String FIELD_IMPURITY="impurity";
  public static String getFieldimpurity() {
    return FIELD_IMPURITY;
  }

  private final static String FIELD_COMPUTRESULT="computResult";
  public static String getFieldcomputResult() {
    return FIELD_COMPUTRESULT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Mechanicalimpuritiessample)) return false;
    Mechanicalimpuritiessample mechanicalimpuritiessample= (Mechanicalimpuritiessample)o;
    return sampleID!= null && sampleID.equals(mechanicalimpuritiessample.sampleID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
