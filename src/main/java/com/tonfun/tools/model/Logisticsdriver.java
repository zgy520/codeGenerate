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
@Table(name="logisticsdriver")
//对应的表为:logisticsdriver
public class Logisticsdriver{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long driverID;
  //bigint(20) 
  @NotNull
  private Long companyID;
  //varchar(50) 
  @NotNull
  private String driverName;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyID")
  private Logisticscompany  logisticscompany;

  //关系实体创建完毕


  public void setDriverID(Long driverID){
    this.driverID = driverID;
  }


  public Long getDriverID(){
    return this.driverID;
  }


  public void setCompanyID(Long companyID){
    this.companyID = companyID;
  }


  public Long getCompanyID(){
    return this.companyID;
  }


  public void setDriverName(String driverName){
    this.driverName = driverName;
  }


  public String getDriverName(){
    return this.driverName;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }
  public Logisticscompany getLogisticscompany() {
    return this.logisticscompany;
  }

  public void setLogisticscompany(Logisticscompany logisticscompany) {
    this.logisticscompany = logisticscompany;
  }

}
