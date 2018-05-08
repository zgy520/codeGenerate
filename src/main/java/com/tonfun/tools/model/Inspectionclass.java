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
@Table(name="inspectionclass")
//对应的表为:inspectionclass
public class Inspectionclass{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long classID;
  //varchar(50) 
  @NotNull
  private String className;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "inspectionclass")
  private Set<Inspectionrecord>  inspectionrecords = new HashSet<>();

  //关系实体创建完毕


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }


  public void setClassName(String className){
    this.className = className;
  }


  public String getClassName(){
    return this.className;
  }
  public Set<Inspectionrecord> getInspectionrecord() {
    return this.inspectionrecords;
  }

  public void setInspectionrecord(Set<Inspectionrecord> inspectionrecords) {
    this.inspectionrecords = inspectionrecords;
  }

}
