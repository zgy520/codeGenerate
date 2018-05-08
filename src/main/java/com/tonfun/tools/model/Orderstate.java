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
@Table(name="orderstate")
//对应的表为:orderstate
public class Orderstate{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long stateID;
  //varchar(50) 
  @NotNull
  private String stateName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "orderstate")
  private Set<Prodgodownentryhistory>  prodgodownentryhistorys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Productionorder>  productionorders = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Prodgodownentry>  prodgodownentrys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Proddeliveryorder>  proddeliveryorders = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Productionorderhistory>  productionorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Salesorder>  salesorders = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  private Set<Proddeliveryorderhistory>  proddeliveryorderhistorys = new HashSet<>();

  //关系实体创建完毕


  public void setStateID(Long stateID){
    this.stateID = stateID;
  }


  public Long getStateID(){
    return this.stateID;
  }


  public void setStateName(String stateName){
    this.stateName = stateName;
  }


  public String getStateName(){
    return this.stateName;
  }
  public Set<Prodgodownentryhistory> getProdgodownentryhistory() {
    return this.prodgodownentryhistorys;
  }

  public void setProdgodownentryhistory(Set<Prodgodownentryhistory> prodgodownentryhistorys) {
    this.prodgodownentryhistorys = prodgodownentryhistorys;
  }

  public Set<Productionorder> getProductionorder() {
    return this.productionorders;
  }

  public void setProductionorder(Set<Productionorder> productionorders) {
    this.productionorders = productionorders;
  }

  public Set<Prodgodownentry> getProdgodownentry() {
    return this.prodgodownentrys;
  }

  public void setProdgodownentry(Set<Prodgodownentry> prodgodownentrys) {
    this.prodgodownentrys = prodgodownentrys;
  }

  public Set<Proddeliveryorder> getProddeliveryorder() {
    return this.proddeliveryorders;
  }

  public void setProddeliveryorder(Set<Proddeliveryorder> proddeliveryorders) {
    this.proddeliveryorders = proddeliveryorders;
  }

  public Set<Productionorderhistory> getProductionorderhistory() {
    return this.productionorderhistorys;
  }

  public void setProductionorderhistory(Set<Productionorderhistory> productionorderhistorys) {
    this.productionorderhistorys = productionorderhistorys;
  }

  public Set<Salesorder> getSalesorder() {
    return this.salesorders;
  }

  public void setSalesorder(Set<Salesorder> salesorders) {
    this.salesorders = salesorders;
  }

  public Set<Proddeliveryorderhistory> getProddeliveryorderhistory() {
    return this.proddeliveryorderhistorys;
  }

  public void setProddeliveryorderhistory(Set<Proddeliveryorderhistory> proddeliveryorderhistorys) {
    this.proddeliveryorderhistorys = proddeliveryorderhistorys;
  }

}
