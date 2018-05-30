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

  @Override
  public String toString() {
    return String.format("unitID=%s,unitName=%s",this.unitID,this.unitName);
  }
  private final static String FIELD_UNITID="unitID";
  public static String getFieldunitID() {
    return FIELD_UNITID;
  }

  private final static String FIELD_UNITNAME="unitName";
  public static String getFieldunitName() {
    return FIELD_UNITNAME;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Materialunit)) return false;
    Materialunit materialunit= (Materialunit)o;
    return unitID!= null && unitID.equals(materialunit.unitID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
