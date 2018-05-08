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
@Table(name="logisticsvehicle")
//对应的表为:logisticsvehicle
public class Logisticsvehicle{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long vehicleID;
  //bigint(20) 
  @NotNull
  private Long companyID;
  //varchar(20) 
  @NotNull
  private String vehicleLicense;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyID")
  private Logisticscompany  logisticscompany;

  //关系实体创建完毕


  public void setVehicleID(Long vehicleID){
    this.vehicleID = vehicleID;
  }


  public Long getVehicleID(){
    return this.vehicleID;
  }


  public void setCompanyID(Long companyID){
    this.companyID = companyID;
  }


  public Long getCompanyID(){
    return this.companyID;
  }


  public void setVehicleLicense(String vehicleLicense){
    this.vehicleLicense = vehicleLicense;
  }


  public String getVehicleLicense(){
    return this.vehicleLicense;
  }
  public Logisticscompany getLogisticscompany() {
    return this.logisticscompany;
  }

  public void setLogisticscompany(Logisticscompany logisticscompany) {
    this.logisticscompany = logisticscompany;
  }

}
