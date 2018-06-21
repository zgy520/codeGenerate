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
@Table(name="testanalysisitem")
//对应的表为:testanalysisitem
public class Testanalysisitem{
  private static final Logger LOGGER = LoggerFactory.getLogger(Testanalysisitem.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long itemID;
  //varchar(50) 
  @NotNull
  private String itemName;
  //varchar(50) 
  @NotNull
  private String qualityTarget;
  //varchar(50) 
  @NotNull
  private String testMethod;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setItemID(Long itemID){
    this.itemID = itemID;
  }


  public Long getItemID(){
    return this.itemID;
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
    return String.format("itemID=%s,itemName=%s,qualityTarget=%s,testMethod=%s",this.itemID,this.itemName,this.qualityTarget,this.testMethod);
  }
  private final static String FIELD_ITEMID="itemID";
  public static String getFielditemID() {
    return FIELD_ITEMID;
  }

  private final static String FIELD_ITEMNAME="itemName";
  public static String getFielditemName() {
    return FIELD_ITEMNAME;
  }

  private final static String FIELD_QUALITYTARGET="qualityTarget";
  public static String getFieldqualityTarget() {
    return FIELD_QUALITYTARGET;
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
    if(!(o instanceof Testanalysisitem)) return false;
    Testanalysisitem testanalysisitem= (Testanalysisitem)o;
    return itemID!= null && itemID.equals(testanalysisitem.itemID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
