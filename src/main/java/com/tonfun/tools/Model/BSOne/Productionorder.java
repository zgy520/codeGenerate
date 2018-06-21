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
@Table(name="productionorder")
//对应的表为:productionorder
public class Productionorder{
  private static final Logger LOGGER = LoggerFactory.getLogger(Productionorder.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long productionOrderID;
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
  @JsonIgnore
  private Product  product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "teamID")
  @JsonIgnore
  private Productionteam  productionteam;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "salesOrderID")
  @JsonIgnore
  private Salesorder  salesorder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stateID")
  @JsonIgnore
  private Orderstate  orderstate;

  @OneToMany(mappedBy = "productionorder")
  @JsonIgnore
  private Set<Inspectionrecord>  inspectionrecords = new HashSet<>();

  @OneToMany(mappedBy = "productionorder")
  @JsonIgnore
  private Set<Productionorderhistory>  productionorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "productionorder")
  @JsonIgnore
  private Set<Prodgodownentry>  prodgodownentrys = new HashSet<>();

  //关系实体创建完毕


  public void setProductionOrderID(Long productionOrderID){
    this.productionOrderID = productionOrderID;
  }


  public Long getProductionOrderID(){
    return this.productionOrderID;
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

  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Set<Inspectionrecord> getInspectionrecord() {
    return this.inspectionrecords;
  }

  public void setInspectionrecord(Set<Inspectionrecord> inspectionrecords) {
    this.inspectionrecords = inspectionrecords;
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

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("productionOrderID=%s,orderNo=%s,orderDate=%s,amount=%s,batchNumber=%s,productionDepart=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s,auditor=%s,auditedTime=%s",this.productionOrderID,this.orderNo,this.orderDate,this.amount,this.batchNumber,this.productionDepart,this.creator,this.createTime,this.updator,this.updateTime,this.auditor,this.auditedTime);
  }
  private final static String FIELD_PRODUCTIONORDERID="productionOrderID";
  public static String getFieldproductionOrderID() {
    return FIELD_PRODUCTIONORDERID;
  }

  private final static String FIELD_ORDERNO="orderNo";
  public static String getFieldorderNo() {
    return FIELD_ORDERNO;
  }

  private final static String FIELD_ORDERDATE="orderDate";
  public static String getFieldorderDate() {
    return FIELD_ORDERDATE;
  }

  private final static String FIELD_AMOUNT="amount";
  public static String getFieldamount() {
    return FIELD_AMOUNT;
  }

  private final static String FIELD_BATCHNUMBER="batchNumber";
  public static String getFieldbatchNumber() {
    return FIELD_BATCHNUMBER;
  }

  private final static String FIELD_PRODUCTIONDEPART="productionDepart";
  public static String getFieldproductionDepart() {
    return FIELD_PRODUCTIONDEPART;
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
    if(!(o instanceof Productionorder)) return false;
    Productionorder productionorder= (Productionorder)o;
    return productionOrderID!= null && productionOrderID.equals(productionorder.productionOrderID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
