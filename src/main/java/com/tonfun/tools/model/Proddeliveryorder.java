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
@Table(name="proddeliveryorder")
//对应的表为:proddeliveryorder
public class Proddeliveryorder{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodDeliveryOrderID;
  //bigint(20) 
  @NotNull
  private Long storehouseID;
  //bigint(20) 
  @NotNull
  private Long orderStateID;
  //varchar(20) 
  @NotNull
  private String orderNo;
  //date 
  @NotNull
  private LocalDate orderDate;
  //varchar(20) 销售号新增
  private String salesNo;
  //varchar(20) 
  private String logisticsOrderNo;
  //varchar(20) 
  @NotNull
  private String salesman;
  //varchar(20) 
  @NotNull
  private String stockman;
  //varchar(20) 
  @NotNull
  private String sender;
  //varchar(20) 
  private String receiver;
  //varchar(50) 
  @NotNull
  private String linkman;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //varchar(50) 
  private String receiverAddr;
  //varchar(20) 
  private String picker;
  //varchar(50) 
  private String driverName;
  //varchar(20) 
  private String vehicleLicense;
  //varchar(20) 
  private String logiCompanyName;
  //varchar(100) 
  private String remark;
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
  @JoinColumn(name = "storehouseID")
  private Storehouse  storehouse;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orderStateID")
  private Orderstate  orderstate;

  @OneToMany(mappedBy = "proddeliveryorder")
  private Set<Proddeliveryorderdetail>  proddeliveryorderdetails = new HashSet<>();

  @OneToMany(mappedBy = "proddeliveryorder")
  private Set<Proddeliveryorderhistory>  proddeliveryorderhistorys = new HashSet<>();

  //关系实体创建完毕


  public void setProdDeliveryOrderID(Long prodDeliveryOrderID){
    this.prodDeliveryOrderID = prodDeliveryOrderID;
  }


  public Long getProdDeliveryOrderID(){
    return this.prodDeliveryOrderID;
  }


  public void setStorehouseID(Long storehouseID){
    this.storehouseID = storehouseID;
  }


  public Long getStorehouseID(){
    return this.storehouseID;
  }


  public void setOrderStateID(Long orderStateID){
    this.orderStateID = orderStateID;
  }


  public Long getOrderStateID(){
    return this.orderStateID;
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


  public void setSalesNo(String salesNo){
    this.salesNo = salesNo;
  }


  public String getSalesNo(){
    return this.salesNo;
  }


  public void setLogisticsOrderNo(String logisticsOrderNo){
    this.logisticsOrderNo = logisticsOrderNo;
  }


  public String getLogisticsOrderNo(){
    return this.logisticsOrderNo;
  }


  public void setSalesman(String salesman){
    this.salesman = salesman;
  }


  public String getSalesman(){
    return this.salesman;
  }


  public void setStockman(String stockman){
    this.stockman = stockman;
  }


  public String getStockman(){
    return this.stockman;
  }


  public void setSender(String sender){
    this.sender = sender;
  }


  public String getSender(){
    return this.sender;
  }


  public void setReceiver(String receiver){
    this.receiver = receiver;
  }


  public String getReceiver(){
    return this.receiver;
  }


  public void setLinkman(String linkman){
    this.linkman = linkman;
  }


  public String getLinkman(){
    return this.linkman;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }


  public void setReceiverAddr(String receiverAddr){
    this.receiverAddr = receiverAddr;
  }


  public String getReceiverAddr(){
    return this.receiverAddr;
  }


  public void setPicker(String picker){
    this.picker = picker;
  }


  public String getPicker(){
    return this.picker;
  }


  public void setDriverName(String driverName){
    this.driverName = driverName;
  }


  public String getDriverName(){
    return this.driverName;
  }


  public void setVehicleLicense(String vehicleLicense){
    this.vehicleLicense = vehicleLicense;
  }


  public String getVehicleLicense(){
    return this.vehicleLicense;
  }


  public void setLogiCompanyName(String logiCompanyName){
    this.logiCompanyName = logiCompanyName;
  }


  public String getLogiCompanyName(){
    return this.logiCompanyName;
  }


  public void setRemark(String remark){
    this.remark = remark;
  }


  public String getRemark(){
    return this.remark;
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
  public Storehouse getStorehouse() {
    return this.storehouse;
  }

  public void setStorehouse(Storehouse storehouse) {
    this.storehouse = storehouse;
  }

  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Set<Proddeliveryorderdetail> getProddeliveryorderdetail() {
    return this.proddeliveryorderdetails;
  }

  public void setProddeliveryorderdetail(Set<Proddeliveryorderdetail> proddeliveryorderdetails) {
    this.proddeliveryorderdetails = proddeliveryorderdetails;
  }

  public Set<Proddeliveryorderhistory> getProddeliveryorderhistory() {
    return this.proddeliveryorderhistorys;
  }

  public void setProddeliveryorderhistory(Set<Proddeliveryorderhistory> proddeliveryorderhistorys) {
    this.proddeliveryorderhistorys = proddeliveryorderhistorys;
  }

}
