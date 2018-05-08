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
@Table(name="materialunit")
//对应的表为:materialunit
public class Materialunit{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long unitID;
  //varchar(50) 
  @NotNull
  private String unitName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "materialunit")
  private Set<Material>  materials = new HashSet<>();

  //关系实体创建完毕


  public void setUnitID(Long unitID){
    this.unitID = unitID;
  }


  public Long getUnitID(){
    return this.unitID;
  }


  public void setUnitName(String unitName){
    this.unitName = unitName;
  }


  public String getUnitName(){
    return this.unitName;
  }
  public Set<Material> getMaterial() {
    return this.materials;
  }

  public void setMaterial(Set<Material> materials) {
    this.materials = materials;
  }

}
