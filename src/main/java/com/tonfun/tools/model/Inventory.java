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
@Table(name="inventory")
//对应的表为:inventory
public class Inventory{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //bigint(20) 
  @NotNull
  private Long storehouseID;
  //bigint(20) 
  @NotNull
  private Long prodID;
  //bigint(20) 
  @NotNull
  private Long amount;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "storehouseID")
  private Storehouse  storehouse;

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


  public void setStorehouseID(Long storehouseID){
    this.storehouseID = storehouseID;
  }


  public Long getStorehouseID(){
    return this.storehouseID;
  }


  public void setProdID(Long prodID){
    this.prodID = prodID;
  }


  public Long getProdID(){
    return this.prodID;
  }


  public void setAmount(Long amount){
    this.amount = amount;
  }


  public Long getAmount(){
    return this.amount;
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

}
