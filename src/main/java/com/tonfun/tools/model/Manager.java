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
@Table(name="manager")
//对应的表为:manager
public class Manager{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  //bigint(20) 
  @NotNull
  private Long orgID;
  //date 
  @NotNull
  private LocalDate sinceDay;
  //date 
  private LocalDate untilDay;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employeeID")
  private Employee  employee;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }



  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }


  public Long getOrgID(){
    return this.orgID;
  }


  public void setSinceDay(LocalDate sinceDay){
    this.sinceDay = sinceDay;
  }


  public LocalDate getSinceDay(){
    return this.sinceDay;
  }


  public void setUntilDay(LocalDate untilDay){
    this.untilDay = untilDay;
  }


  public LocalDate getUntilDay(){
    return this.untilDay;
  }
}
