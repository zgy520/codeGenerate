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
@Table(name="employee")
//对应的表为:employee
public class Employee{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long employeeID;
  //bigint(20) 
  private Long classID;
  //bigint(20)  
  //varchar(50) 
  @NotNull
  private String employeeName;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //bigint(20) 
  @NotNull
  private Long orgID;
  //bigint(20) 
  private Long userID;
  //以下是对应的实体关系  

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "posID")
  private Position  position;

 

  @OneToMany(mappedBy = "employee")
  private Set<Manager>  managers = new HashSet<>();

  //关系实体创建完毕


  public void setEmployeeID(Long employeeID){
    this.employeeID = employeeID;
  }


  public Long getEmployeeID(){
    return this.employeeID;
  }


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }
 


  public void setEmployeeName(String employeeName){
    this.employeeName = employeeName;
  }


  public String getEmployeeName(){
    return this.employeeName;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }


  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }


  public Long getOrgID(){
    return this.orgID;
  }


  public void setUserID(Long userID){
    this.userID = userID;
  }


  public Long getUserID(){
    return this.userID;
  }
}
