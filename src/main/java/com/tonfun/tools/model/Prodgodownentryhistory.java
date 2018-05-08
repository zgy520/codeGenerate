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
@Table(name="prodgodownentryhistory")
//对应的表为:prodgodownentryhistory
public class Prodgodownentryhistory{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long stateID;
  //bigint(20) 
  @NotNull
  private Long prodGodownEntryID;
  //datetime 
  @NotNull
  private LocalDateTime operationTime;
  //varchar(20) 
  @NotNull
  private String operator;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stateID")
  private Orderstate  orderstate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodGodownEntryID")
  private Prodgodownentry  prodgodownentry;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setStateID(Long stateID){
    this.stateID = stateID;
  }


  public Long getStateID(){
    return this.stateID;
  }


  public void setProdGodownEntryID(Long prodGodownEntryID){
    this.prodGodownEntryID = prodGodownEntryID;
  }


  public Long getProdGodownEntryID(){
    return this.prodGodownEntryID;
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
  public Orderstate getOrderstate() {
    return this.orderstate;
  }

  public void setOrderstate(Orderstate orderstate) {
    this.orderstate = orderstate;
  }

  public Prodgodownentry getProdgodownentry() {
    return this.prodgodownentry;
  }

  public void setProdgodownentry(Prodgodownentry prodgodownentry) {
    this.prodgodownentry = prodgodownentry;
  }

}
