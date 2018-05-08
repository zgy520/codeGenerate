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
@Table(name="prodbrand")
//对应的表为:prodbrand
public class Prodbrand{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long brandID;
  //varchar(50) 
  @NotNull
  private String brandName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "prodbrand")
  private Set<Product>  products = new HashSet<>();

  //关系实体创建完毕


  public void setBrandID(Long brandID){
    this.brandID = brandID;
  }


  public Long getBrandID(){
    return this.brandID;
  }


  public void setBrandName(String brandName){
    this.brandName = brandName;
  }


  public String getBrandName(){
    return this.brandName;
  }
  public Set<Product> getProduct() {
    return this.products;
  }

  public void setProduct(Set<Product> products) {
    this.products = products;
  }

}
