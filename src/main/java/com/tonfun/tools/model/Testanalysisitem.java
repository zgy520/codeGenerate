package com.tonfun.tools.model;


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
@Table(name="testanalysisitem")
//对应的表为:testanalysisitem
public class Testanalysisitem{
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
}
