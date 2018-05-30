package com.tonfun.tools.Model;


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
@Table(name="proddeliveryorderhistory")
//对应的表为:proddeliveryorderhistory
public class Proddeliveryorderhistory{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //datetime 
  private LocalDateTime operationTime;
  //varchar(20) 
  @NotNull
  private String operator;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodDeliveryOrderID")
  private Proddeliveryorder  proddeliveryorder;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stateID")
  private Orderstate  orderstate;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setOperationTime(LocalDateTime operationTime){
    this.operationTime = operationTime;
  }


  public LocalDateTime getOperationTime(){
    return this.operationTime;
  }


  public void setOperator(String operator){
    this.operator = operator;
  }


  public String getOperator(){
    return this.operator;
  }
  public Proddeliveryorder getProddeliveryorder() {
    return this.proddeliveryorder;
  }

  public void setProddeliveryorder(Proddeliveryorder proddeliveryorder) {
    this.proddeliveryorder = proddeliveryorder;
  }

  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  @Override
  public String toString() {
    return String.format("recordID=%s,operationTime=%s,operator=%s",this.recordID,this.operationTime,this.operator);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_OPERATIONTIME="operationTime";
  public static String getFieldoperationTime() {
    return FIELD_OPERATIONTIME;
  }

  private final static String FIELD_OPERATOR="operator";
  public static String getFieldoperator() {
    return FIELD_OPERATOR;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Proddeliveryorderhistory)) return false;
    Proddeliveryorderhistory proddeliveryorderhistory= (Proddeliveryorderhistory)o;
    return recordID!= null && recordID.equals(proddeliveryorderhistory.recordID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
