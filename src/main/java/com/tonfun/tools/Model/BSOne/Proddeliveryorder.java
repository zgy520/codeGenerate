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
@Table(name="proddeliveryorder")
//对应的表为:proddeliveryorder
public class Proddeliveryorder{
  private static final Logger LOGGER = LoggerFactory.getLogger(Proddeliveryorder.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodDeliveryOrderID;
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
  @JsonIgnore
  private Storehouse  storehouse;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orderStateID")
  @JsonIgnore
  private Orderstate  orderstate;

  @OneToMany(mappedBy = "proddeliveryorder")
  @JsonIgnore
  private Set<Proddeliveryorderdetail>  proddeliveryorderdetails = new HashSet<>();

  @OneToMany(mappedBy = "proddeliveryorder")
  @JsonIgnore
  private Set<Proddeliveryorderhistory>  proddeliveryorderhistorys = new HashSet<>();

  //关系实体创建完毕


  public void setProdDeliveryOrderID(Long prodDeliveryOrderID){
    this.prodDeliveryOrderID = prodDeliveryOrderID;
  }


  public Long getProdDeliveryOrderID(){
    return this.prodDeliveryOrderID;
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

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("prodDeliveryOrderID=%s,orderNo=%s,orderDate=%s,salesNo=%s,logisticsOrderNo=%s,salesman=%s,stockman=%s,sender=%s,receiver=%s,linkman=%s,phoneNumber=%s,receiverAddr=%s,picker=%s,driverName=%s,vehicleLicense=%s,logiCompanyName=%s,remark=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s,auditor=%s,auditedTime=%s",this.prodDeliveryOrderID,this.orderNo,this.orderDate,this.salesNo,this.logisticsOrderNo,this.salesman,this.stockman,this.sender,this.receiver,this.linkman,this.phoneNumber,this.receiverAddr,this.picker,this.driverName,this.vehicleLicense,this.logiCompanyName,this.remark,this.creator,this.createTime,this.updator,this.updateTime,this.auditor,this.auditedTime);
  }
  private final static String FIELD_PRODDELIVERYORDERID="prodDeliveryOrderID";
  public static String getFieldprodDeliveryOrderID() {
    return FIELD_PRODDELIVERYORDERID;
  }

  private final static String FIELD_ORDERNO="orderNo";
  public static String getFieldorderNo() {
    return FIELD_ORDERNO;
  }

  private final static String FIELD_ORDERDATE="orderDate";
  public static String getFieldorderDate() {
    return FIELD_ORDERDATE;
  }

  private final static String FIELD_SALESNO="salesNo";
  public static String getFieldsalesNo() {
    return FIELD_SALESNO;
  }

  private final static String FIELD_LOGISTICSORDERNO="logisticsOrderNo";
  public static String getFieldlogisticsOrderNo() {
    return FIELD_LOGISTICSORDERNO;
  }

  private final static String FIELD_SALESMAN="salesman";
  public static String getFieldsalesman() {
    return FIELD_SALESMAN;
  }

  private final static String FIELD_STOCKMAN="stockman";
  public static String getFieldstockman() {
    return FIELD_STOCKMAN;
  }

  private final static String FIELD_SENDER="sender";
  public static String getFieldsender() {
    return FIELD_SENDER;
  }

  private final static String FIELD_RECEIVER="receiver";
  public static String getFieldreceiver() {
    return FIELD_RECEIVER;
  }

  private final static String FIELD_LINKMAN="linkman";
  public static String getFieldlinkman() {
    return FIELD_LINKMAN;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  private final static String FIELD_RECEIVERADDR="receiverAddr";
  public static String getFieldreceiverAddr() {
    return FIELD_RECEIVERADDR;
  }

  private final static String FIELD_PICKER="picker";
  public static String getFieldpicker() {
    return FIELD_PICKER;
  }

  private final static String FIELD_DRIVERNAME="driverName";
  public static String getFielddriverName() {
    return FIELD_DRIVERNAME;
  }

  private final static String FIELD_VEHICLELICENSE="vehicleLicense";
  public static String getFieldvehicleLicense() {
    return FIELD_VEHICLELICENSE;
  }

  private final static String FIELD_LOGICOMPANYNAME="logiCompanyName";
  public static String getFieldlogiCompanyName() {
    return FIELD_LOGICOMPANYNAME;
  }

  private final static String FIELD_REMARK="remark";
  public static String getFieldremark() {
    return FIELD_REMARK;
  }

  private final static String FIELD_CREATOR="creator";
  public static String getFieldcreator() {
    return FIELD_CREATOR;
  }

  private final static String FIELD_CREATETIME="createTime";
  public static String getFieldcreateTime() {
    return FIELD_CREATETIME;
  }

  private final static String FIELD_UPDATOR="updator";
  public static String getFieldupdator() {
    return FIELD_UPDATOR;
  }

  private final static String FIELD_UPDATETIME="updateTime";
  public static String getFieldupdateTime() {
    return FIELD_UPDATETIME;
  }

  private final static String FIELD_AUDITOR="auditor";
  public static String getFieldauditor() {
    return FIELD_AUDITOR;
  }

  private final static String FIELD_AUDITEDTIME="auditedTime";
  public static String getFieldauditedTime() {
    return FIELD_AUDITEDTIME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Proddeliveryorder)) return false;
    Proddeliveryorder proddeliveryorder= (Proddeliveryorder)o;
    return prodDeliveryOrderID!= null && prodDeliveryOrderID.equals(proddeliveryorder.prodDeliveryOrderID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
