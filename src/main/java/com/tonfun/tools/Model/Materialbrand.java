package com.tonfun.tools.Model;


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
@Table(name="materialbrand")
//对应的表为:materialbrand
public class Materialbrand{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long brandID;
  //varchar(50) 
  @NotNull
  private String brandName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "materialbrand")
  private Set<Material>  materials = new HashSet<>();

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
  public Set<Material> getMaterial() {
    return this.materials;
  }

  public void setMaterial(Set<Material> materials) {
    this.materials = materials;
  }

  @Override
  public String toString() {
    return String.format("brandID=%s,brandName=%s",this.brandID,this.brandName);
  }
  private final static String FIELD_BRANDID="brandID";
  public static String getFieldbrandID() {
    return FIELD_BRANDID;
  }

  private final static String FIELD_BRANDNAME="brandName";
  public static String getFieldbrandName() {
    return FIELD_BRANDNAME;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Materialbrand)) return false;
    Materialbrand materialbrand= (Materialbrand)o;
    return brandID!= null && brandID.equals(materialbrand.brandID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
