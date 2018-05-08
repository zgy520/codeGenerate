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
@Table(name="salesorder")
//对应的表为:salesorder
public class Salesorder{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long salesOrderID;
  //bigint(20) 
  @NotNull
  private Long stateID;
  //varchar(20) 
  @NotNull
  private String orderNo;
  //date 
  @NotNull
  private LocalDate orderDate;
  //varchar(20) 
  @NotNull
  private String salesman;
  //varchar(20) 
  @NotNull
  private String salesmanDepart;
  //varchar(20) 
  @NotNull
  private String creator;
  //datetime 
  @NotNull
  private LocalDateTime createTime;
  //varchar(20) 
  private String updator;
  //datetime 
  private LocalDateTime updateTime;
  //varchar(20) 
  private String auditor;
  //datetime 
  private LocalDateTime auditedTime;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stateID")
  private Orderstate  orderstate;

  @OneToMany(mappedBy = "salesorder")
  private Set<Salesorderhistory>  salesorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "salesorder")
  private Set<Productionorder>  productionorders = new HashSet<>();

  @OneToMany(mappedBy = "salesorder")
  private Set<Salesorderdetail>  salesorderdetails = new HashSet<>();

  //关系实体创建完毕


  public void setSalesOrderID(Long salesOrderID){
    this.salesOrderID = salesOrderID;
  }


  public Long getSalesOrderID(){
    return this.salesOrderID;
  }


  public void setStateID(Long stateID){
    this.stateID = stateID;
  }


  public Long getStateID(){
    return this.stateID;
  }


  public void setOrderNo(String orderNo){
    this.orderNo = orderNo;
  }


  public String getOrderNo(){
    return this.orderNo;
  }


  public void setOrderDate(LocalDate orderDate){
    this.orderDate = orderDate;
  }


  public LocalDate getOrderDate(){
    return this.orderDate;
  }


  public void setSalesman(String salesman){
    this.salesman = salesman;
  }


  public String getSalesman(){
    return this.salesman;
  }


  public void setSalesmanDepart(String salesmanDepart){
    this.salesmanDepart = salesmanDepart;
  }


  public String getSalesmanDepart(){
    return this.salesmanDepart;
  }


  public void setCreator(String creator){
    this.creator = creator;
  }


  public String getCreator(){
    return this.creator;
  }


  public void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
  }


  public LocalDateTime getCreateTime(){
    return this.createTime;
  }


  public void setUpdator(String updator){
    this.updator = updator;
  }


  public String getUpdator(){
    return this.updator;
  }


  public void setUpdateTime(LocalDateTime updateTime){
    this.updateTime = updateTime;
  }


  public LocalDateTime getUpdateTime(){
    return this.updateTime;
  }


  public void setAuditor(String auditor){
    this.auditor = auditor;
  }


  public String getAuditor(){
    return this.auditor;
  }


  public void setAuditedTime(LocalDateTime auditedTime){
    this.auditedTime = auditedTime;
  }


  public LocalDateTime getAuditedTime(){
    return this.auditedTime;
  }
  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Set<Salesorderhistory> getSalesorderhistory() {
    return this.salesorderhistorys;
  }

  public void setSalesorderhistory(Set<Salesorderhistory> salesorderhistorys) {
    this.salesorderhistorys = salesorderhistorys;
  }

  public Set<Productionorder> getProductionorder() {
    return this.productionorders;
  }

  public void setProductionorder(Set<Productionorder> productionorders) {
    this.productionorders = productionorders;
  }

  public Set<Salesorderdetail> getSalesorderdetail() {
    return this.salesorderdetails;
  }

  public void setSalesorderdetail(Set<Salesorderdetail> salesorderdetails) {
    this.salesorderdetails = salesorderdetails;
  }

}
