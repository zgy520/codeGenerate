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
@Table(name="foamitem")
//对应的表为:foamitem
public class Foamitem{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long itemID;
  //varchar(50) 
  @NotNull
  private String itemName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "foamitem")
  private Set<Foamrecord>  foamrecords = new HashSet<>();

  //关系实体创建完毕


  public void setItemID(Long itemID){
    this.itemID = itemID;
  }


  public Long getItemID(){
    return this.itemID;
  }


  public void setItemName(String itemName){
    this.itemName = itemName;
  }


  public String getItemName(){
    return this.itemName;
  }
  public Set<Foamrecord> getFoamrecord() {
    return this.foamrecords;
  }

  public void setFoamrecord(Set<Foamrecord> foamrecords) {
    this.foamrecords = foamrecords;
  }

}
