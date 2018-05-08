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
@Table(name="testanalysisconclusion")
//对应的表为:testanalysisconclusion
public class Testanalysisconclusion{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long conclusionID;
  //varchar(20) 
  @NotNull
  private String conclusionName;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setConclusionID(Long conclusionID){
    this.conclusionID = conclusionID;
  }


  public Long getConclusionID(){
    return this.conclusionID;
  }


  public void setConclusionName(String conclusionName){
    this.conclusionName = conclusionName;
  }


  public String getConclusionName(){
    return this.conclusionName;
  }
}
