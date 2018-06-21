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
@Table(name="inventorylog")
//对应的表为:inventorylog
public class Inventorylog{
  private static final Logger LOGGER = LoggerFactory.getLogger(Inventorylog.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //varchar(20) 
  @NotNull
  private String causeOrderNo;
  //bigint(20) 
  @NotNull
  private Long oldAmount;
  //bigint(20) 
  @NotNull
  private Long curAmount;
  //varchar(20) 
  @NotNull
  private String operator;
  //datetime 
  private LocalDateTime operationTime;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storehouseID")
  @JsonIgnore
  private Storehouse  storehouse;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodID")
  @JsonIgnore
  private Product  product;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setCauseOrderNo(String causeOrderNo){
    this.causeOrderNo = causeOrderNo;
  }


  public String getCauseOrderNo(){
    return this.causeOrderNo;
  }


  public void setOldAmount(Long oldAmount){
    this.oldAmount = oldAmount;
  }


  public Long getOldAmount(){
    return this.oldAmount;
  }


  public void setCurAmount(Long curAmount){
    this.curAmount = curAmount;
  }


  public Long getCurAmount(){
    return this.curAmount;
  }


  public void setOperator(String operator){
    this.operator = operator;
  }


  public String getOperator(){
    return this.operator;
  }


  public void setOperationTime(LocalDateTime operationTime){
    this.operationTime = operationTime;
  }


  public LocalDateTime getOperationTime(){
    return this.operationTime;
  }
  public Storehouse getStorehouse() {
    return this.storehouse;
  }

  public void setStorehouse(Storehouse storehouse) {
    this.storehouse = storehouse;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,causeOrderNo=%s,oldAmount=%s,curAmount=%s,operator=%s,operationTime=%s",this.recordID,this.causeOrderNo,this.oldAmount,this.curAmount,this.operator,this.operationTime);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_CAUSEORDERNO="causeOrderNo";
  public static String getFieldcauseOrderNo() {
    return FIELD_CAUSEORDERNO;
  }

  private final static String FIELD_OLDAMOUNT="oldAmount";
  public static String getFieldoldAmount() {
    return FIELD_OLDAMOUNT;
  }

  private final static String FIELD_CURAMOUNT="curAmount";
  public static String getFieldcurAmount() {
    return FIELD_CURAMOUNT;
  }

  private final static String FIELD_OPERATOR="operator";
  public static String getFieldoperator() {
    return FIELD_OPERATOR;
  }

  private final static String FIELD_OPERATIONTIME="operationTime";
  public static String getFieldoperationTime() {
    return FIELD_OPERATIONTIME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Inventorylog)) return false;
    Inventorylog inventorylog= (Inventorylog)o;
    return recordID!= null && recordID.equals(inventorylog.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
