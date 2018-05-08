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
@Table(name="product")
//对应的表为:product
public class Product{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodID;
  //bigint(20) 
  @NotNull
  private Long modelID;
  //bigint(20) 
  @NotNull
  private Long specID;
  //bigint(20) 
  @NotNull
  private Long unitID;
  //bigint(20) 
  @NotNull
  private Long brandID;
  //varchar(50) 
  @NotNull
  private String prodname;
  //varchar(50) 
  private String specifications;
  //以下是对应的实体关系  
  //关系实体创建完毕


  public void setProdID(Long prodID){
    this.prodID = prodID;
  }


  public Long getProdID(){
    return this.prodID;
  }


  public void setModelID(Long modelID){
    this.modelID = modelID;
  }


  public Long getModelID(){
    return this.modelID;
  }


  public void setSpecID(Long specID){
    this.specID = specID;
  }


  public Long getSpecID(){
    return this.specID;
  }


  public void setUnitID(Long unitID){
    this.unitID = unitID;
  }


  public Long getUnitID(){
    return this.unitID;
  }


  public void setBrandID(Long brandID){
    this.brandID = brandID;
  }


  public Long getBrandID(){
    return this.brandID;
  }


  public void setProdName(String prodName){
    this.prodname = prodName;
  }


  public String getProdName(){
    return this.prodname;
  }


  public void setSpecifications(String specifications){
    this.specifications = specifications;
  }


  public String getSpecifications(){
    return this.specifications;
  }
}
