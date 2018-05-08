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
@Table(name="productionorder")
//对应的表为:productionorder
public class Productionorder{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long productionOrderID;
  //bigint(20) 
  @NotNull
  private Long prodID;
  //bigint(20) 
  @NotNull
  private Long salesOrderID;
  //bigint(20) 
  @NotNull
  private Long teamID;
  //bigint(20) 
  @NotNull
  private Long stateID;
  //varchar(20) 
  @NotNull
  private String orderNo;
  //date 
  @NotNull
  private LocalDate orderDate;
  //int(11) 
  @NotNull
  private int amount;
  //varchar(20) 
  private String batchNumber;
  //varchar(20) 
  @NotNull
  private String productionDepart;
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
  @JoinColumn(name = "prodID")
  private Product  product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stateID")
  private Orderstate  orderstate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "teamID")
  private Productionteam  productionteam;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "salesOrderID")
  private Salesorder  salesorder;

  @OneToMany(mappedBy = "productionorder")
  private Set<Productionorderhistory>  productionorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "productionorder")
  private Set<Prodgodownentry>  prodgodownentrys = new HashSet<>();

  @OneToMany(mappedBy = "productionorder")
  private Set<Inspectionrecord>  inspectionrecords = new HashSet<>();

  //关系实体创建完毕


  public void setProductionOrderID(Long productionOrderID){
    this.productionOrderID = productionOrderID;
  }


  public Long getProductionOrderID(){
    return this.productionOrderID;
  }


  public void setProdID(Long prodID){
    this.prodID = prodID;
  }


  public Long getProdID(){
    return this.prodID;
  }


  public void setSalesOrderID(Long salesOrderID){
    this.salesOrderID = salesOrderID;
  }


  public Long getSalesOrderID(){
    return this.salesOrderID;
  }


  public void setTeamID(Long teamID){
    this.teamID = teamID;
  }


  public Long getTeamID(){
    return this.teamID;
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


  public void setAmount(int amount){
    this.amount = amount;
  }


  public int getAmount(){
    return this.amount;
  }


  public void setBatchNumber(String batchNumber){
    this.batchNumber = batchNumber;
  }


  public String getBatchNumber(){
    return this.batchNumber;
  }


  public void setProductionDepart(String productionDepart){
    this.productionDepart = productionDepart;
  }


  public String getProductionDepart(){
    return this.productionDepart;
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
  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Productionteam getProductionteam() {
    return this.productionteam;
  }

  public void setProductionteam(Productionteam productionteam) {
    this.productionteam = productionteam;
  }

  public Salesorder getSalesorder() {
    return this.salesorder;
  }

  public void setSalesorder(Salesorder salesorder) {
    this.salesorder = salesorder;
  }

  public Set<Productionorderhistory> getProductionorderhistory() {
    return this.productionorderhistorys;
  }

  public void setProductionorderhistory(Set<Productionorderhistory> productionorderhistorys) {
    this.productionorderhistorys = productionorderhistorys;
  }

  public Set<Prodgodownentry> getProdgodownentry() {
    return this.prodgodownentrys;
  }

  public void setProdgodownentry(Set<Prodgodownentry> prodgodownentrys) {
    this.prodgodownentrys = prodgodownentrys;
  }

  public Set<Inspectionrecord> getInspectionrecord() {
    return this.inspectionrecords;
  }

  public void setInspectionrecord(Set<Inspectionrecord> inspectionrecords) {
    this.inspectionrecords = inspectionrecords;
  }

}
