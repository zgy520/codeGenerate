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
@Table(name="godownkeeper")
//对应的表为:godownkeeper
public class Godownkeeper{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 员工ID
  @NotNull
  private Long employeeID;
  //bigint(20) 仓库ID
  @NotNull
  private Long storehouseID;
  //date 开始日期
  @NotNull
  private LocalDate sinceDay;
  //date 截止日期
  private LocalDate untilDay;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storehouseID")
  private Storehouse  storehouse;

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


  public void setEmployeeID(Long employeeID){
    this.employeeID = employeeID;
  }


  public Long getEmployeeID(){
    return this.employeeID;
  }


  public void setStorehouseID(Long storehouseID){
    this.storehouseID = storehouseID;
  }


  public Long getStorehouseID(){
    return this.storehouseID;
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
  public Storehouse getStorehouse() {
    return this.storehouse;
  }

  public void setStorehouse(Storehouse storehouse) {
    this.storehouse = storehouse;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}
