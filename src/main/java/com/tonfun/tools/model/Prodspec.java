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
@Table(name="prodspec")
//对应的表为:prodspec
public class Prodspec{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long specID;
  //varchar(50) 
  @NotNull
  private String specName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "prodspec")
  private Set<Product>  products = new HashSet<>();

  //关系实体创建完毕


  public void setSpecID(Long specID){
    this.specID = specID;
  }


  public Long getSpecID(){
    return this.specID;
  }


  public void setSpecName(String specName){
    this.specName = specName;
  }


  public String getSpecName(){
    return this.specName;
  }
  public Set<Product> getProduct() {
    return this.products;
  }

  public void setProduct(Set<Product> products) {
    this.products = products;
  }

}
