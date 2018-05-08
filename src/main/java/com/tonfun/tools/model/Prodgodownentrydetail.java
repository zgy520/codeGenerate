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
@Table(name="prodgodownentrydetail")
//对应的表为:prodgodownentrydetail
public class Prodgodownentrydetail{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long prodGodownEntryID;
  //bigint(20) 
  @NotNull
  private Long prodID;
  //int(11) 
  @NotNull
  private int amount;
  //varchar(100) 
  private String remark;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodGodownEntryID")
  private Prodgodownentry  prodgodownentry;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodID")
  private Product  product;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setProdGodownEntryID(Long prodGodownEntryID){
    this.prodGodownEntryID = prodGodownEntryID;
  }


  public Long getProdGodownEntryID(){
    return this.prodGodownEntryID;
  }


  public void setProdID(Long prodID){
    this.prodID = prodID;
  }


  public Long getProdID(){
    return this.prodID;
  }


  public void setAmount(int amount){
    this.amount = amount;
  }


  public int getAmount(){
    return this.amount;
  }


  public void setRemark(String remark){
    this.remark = remark;
  }


  public String getRemark(){
    return this.remark;
  }
  public Prodgodownentry getProdgodownentry() {
    return this.prodgodownentry;
  }

  public void setProdgodownentry(Prodgodownentry prodgodownentry) {
    this.prodgodownentry = prodgodownentry;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}
