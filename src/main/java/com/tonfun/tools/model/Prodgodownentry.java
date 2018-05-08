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
@Table(name="prodgodownentry")
//对应的表为:prodgodownentry
public class Prodgodownentry{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodGodownEntryID;
  //bigint(20) 
  @NotNull
  private Long productionOrderID;
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
  //varchar(20) 
  @NotNull
  private String senderDepart;
  //varchar(20) 
  @NotNull
  private String sender;
  //varchar(20) 
  private String stockman;
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
  @JoinColumn(name = "productionOrderID")
  private Productionorder  productionorder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orderStateID")
  private Orderstate  orderstate;

  @OneToMany(mappedBy = "prodgodownentry")
  private Set<Prodgodownentrydetail>  prodgodownentrydetails = new HashSet<>();

  @OneToMany(mappedBy = "prodgodownentry")
  private Set<Prodgodownentryhistory>  prodgodownentryhistorys = new HashSet<>();

  //关系实体创建完毕


  public void setProdGodownEntryID(Long prodGodownEntryID){
    this.prodGodownEntryID = prodGodownEntryID;
  }


  public Long getProdGodownEntryID(){
    return this.prodGodownEntryID;
  }


  public void setProductionOrderID(Long productionOrderID){
    this.productionOrderID = productionOrderID;
  }


  public Long getProductionOrderID(){
    return this.productionOrderID;
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


  public void setSenderDepart(String senderDepart){
    this.senderDepart = senderDepart;
  }


  public String getSenderDepart(){
    return this.senderDepart;
  }


  public void setSender(String sender){
    this.sender = sender;
  }


  public String getSender(){
    return this.sender;
  }


  public void setStockman(String stockman){
    this.stockman = stockman;
  }


  public String getStockman(){
    return this.stockman;
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

  public Productionorder getProductionorder() {
    return this.productionorder;
  }

  public void setProductionorder(Productionorder productionorder) {
    this.productionorder = productionorder;
  }

  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Set<Prodgodownentrydetail> getProdgodownentrydetail() {
    return this.prodgodownentrydetails;
  }

  public void setProdgodownentrydetail(Set<Prodgodownentrydetail> prodgodownentrydetails) {
    this.prodgodownentrydetails = prodgodownentrydetails;
  }

  public Set<Prodgodownentryhistory> getProdgodownentryhistory() {
    return this.prodgodownentryhistorys;
  }

  public void setProdgodownentryhistory(Set<Prodgodownentryhistory> prodgodownentryhistorys) {
    this.prodgodownentryhistorys = prodgodownentryhistorys;
  }

}
