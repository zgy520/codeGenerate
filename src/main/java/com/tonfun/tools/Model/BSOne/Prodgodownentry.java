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
@Table(name="prodgodownentry")
//对应的表为:prodgodownentry
public class Prodgodownentry{
  private static final Logger LOGGER = LoggerFactory.getLogger(Prodgodownentry.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodGodownEntryID;
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
  @JoinColumn(name = "orderStateID")
  @JsonIgnore
  private Orderstate  orderstate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "productionOrderID")
  @JsonIgnore
  private Productionorder  productionorder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storehouseID")
  @JsonIgnore
  private Storehouse  storehouse;

  @OneToMany(mappedBy = "prodgodownentry")
  @JsonIgnore
  private Set<Prodgodownentryhistory>  prodgodownentryhistorys = new HashSet<>();

  @OneToMany(mappedBy = "prodgodownentry")
  @JsonIgnore
  private Set<Prodgodownentrydetail>  prodgodownentrydetails = new HashSet<>();

  //关系实体创建完毕


  public void setProdGodownEntryID(Long prodGodownEntryID){
    this.prodGodownEntryID = prodGodownEntryID;
  }


  public Long getProdGodownEntryID(){
    return this.prodGodownEntryID;
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
  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Productionorder getProductionorder() {
    return this.productionorder;
  }

  public void setProductionorder(Productionorder productionorder) {
    this.productionorder = productionorder;
  }

  public Storehouse getStorehouse() {
    return this.storehouse;
  }

  public void setStorehouse(Storehouse storehouse) {
    this.storehouse = storehouse;
  }

  public Set<Prodgodownentryhistory> getProdgodownentryhistory() {
    return this.prodgodownentryhistorys;
  }

  public void setProdgodownentryhistory(Set<Prodgodownentryhistory> prodgodownentryhistorys) {
    this.prodgodownentryhistorys = prodgodownentryhistorys;
  }

  public Set<Prodgodownentrydetail> getProdgodownentrydetail() {
    return this.prodgodownentrydetails;
  }

  public void setProdgodownentrydetail(Set<Prodgodownentrydetail> prodgodownentrydetails) {
    this.prodgodownentrydetails = prodgodownentrydetails;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("prodGodownEntryID=%s,orderNo=%s,orderDate=%s,senderDepart=%s,sender=%s,stockman=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s,auditor=%s,auditedTime=%s",this.prodGodownEntryID,this.orderNo,this.orderDate,this.senderDepart,this.sender,this.stockman,this.creator,this.createTime,this.updator,this.updateTime,this.auditor,this.auditedTime);
  }
  private final static String FIELD_PRODGODOWNENTRYID="prodGodownEntryID";
  public static String getFieldprodGodownEntryID() {
    return FIELD_PRODGODOWNENTRYID;
  }

  private final static String FIELD_ORDERNO="orderNo";
  public static String getFieldorderNo() {
    return FIELD_ORDERNO;
  }

  private final static String FIELD_ORDERDATE="orderDate";
  public static String getFieldorderDate() {
    return FIELD_ORDERDATE;
  }

  private final static String FIELD_SENDERDEPART="senderDepart";
  public static String getFieldsenderDepart() {
    return FIELD_SENDERDEPART;
  }

  private final static String FIELD_SENDER="sender";
  public static String getFieldsender() {
    return FIELD_SENDER;
  }

  private final static String FIELD_STOCKMAN="stockman";
  public static String getFieldstockman() {
    return FIELD_STOCKMAN;
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
    if(!(o instanceof Prodgodownentry)) return false;
    Prodgodownentry prodgodownentry= (Prodgodownentry)o;
    return prodGodownEntryID!= null && prodGodownEntryID.equals(prodgodownentry.prodGodownEntryID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
