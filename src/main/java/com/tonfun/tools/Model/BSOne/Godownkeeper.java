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
@Table(name="godownkeeper")
//对应的表为:godownkeeper
public class Godownkeeper{
  private static final Logger LOGGER = LoggerFactory.getLogger(Godownkeeper.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //date 开始日期
  @NotNull
  private LocalDate sinceDay;
  //date 截止日期
  private LocalDate untilDay;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employeeID")
  @JsonIgnore
  private Employee  employee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storehouseID")
  @JsonIgnore
  private Storehouse  storehouse;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
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
  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Storehouse getStorehouse() {
    return this.storehouse;
  }

  public void setStorehouse(Storehouse storehouse) {
    this.storehouse = storehouse;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,sinceDay=%s,untilDay=%s",this.recordID,this.sinceDay,this.untilDay);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_SINCEDAY="sinceDay";
  public static String getFieldsinceDay() {
    return FIELD_SINCEDAY;
  }

  private final static String FIELD_UNTILDAY="untilDay";
  public static String getFielduntilDay() {
    return FIELD_UNTILDAY;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Godownkeeper)) return false;
    Godownkeeper godownkeeper= (Godownkeeper)o;
    return recordID!= null && recordID.equals(godownkeeper.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
