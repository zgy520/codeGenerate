package com.tonfun.tools.Model;


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

  @Override
  public String toString() {
    return String.format("vehicleID=%s,vehicleLicense=%s",this.vehicleID,this.vehicleLicense);
  }
  private final static String FIELD_VEHICLEID="vehicleID";
  public static String getFieldvehicleID() {
    return FIELD_VEHICLEID;
  }

  private final static String FIELD_VEHICLELICENSE="vehicleLicense";
  public static String getFieldvehicleLicense() {
    return FIELD_VEHICLELICENSE;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Logisticsvehicle)) return false;
    Logisticsvehicle logisticsvehicle= (Logisticsvehicle)o;
    return vehicleID!= null && vehicleID.equals(logisticsvehicle.vehicleID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
