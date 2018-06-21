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
@Table(name="logisticsdriver")
//对应的表为:logisticsdriver
public class Logisticsdriver{
  private static final Logger LOGGER = LoggerFactory.getLogger(Logisticsdriver.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long driverID;
  //varchar(50) 
  @NotNull
  private String driverName;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyID")
  @JsonIgnore
  private Logisticscompany  logisticscompany;

  //关系实体创建完毕


  public void setDriverID(Long driverID){
    this.driverID = driverID;
  }


  public Long getDriverID(){
    return this.driverID;
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

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("driverID=%s,driverName=%s,phoneNumber=%s",this.driverID,this.driverName,this.phoneNumber);
  }
  private final static String FIELD_DRIVERID="driverID";
  public static String getFielddriverID() {
    return FIELD_DRIVERID;
  }

  private final static String FIELD_DRIVERNAME="driverName";
  public static String getFielddriverName() {
    return FIELD_DRIVERNAME;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Logisticsdriver)) return false;
    Logisticsdriver logisticsdriver= (Logisticsdriver)o;
    return driverID!= null && driverID.equals(logisticsdriver.driverID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
