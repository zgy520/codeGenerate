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
@Table(name="prodmodel")
//对应的表为:prodmodel
public class Prodmodel{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long modelID;
  //varchar(50) 
  @NotNull
  private String modelName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "prodmodel")
  private Set<Product>  products = new HashSet<>();

  //关系实体创建完毕


  public void setModelID(Long modelID){
    this.modelID = modelID;
  }


  public Long getModelID(){
    return this.modelID;
  }


  public void setModelName(String modelName){
    this.modelName = modelName;
  }


  public String getModelName(){
    return this.modelName;
  }
  public Set<Product> getProduct() {
    return this.products;
  }

  public void setProduct(Set<Product> products) {
    this.products = products;
  }

}
