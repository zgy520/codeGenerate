package com.tonfun.tools.Model.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
import com.tonfun.tools.Auditing.hibernate.AuditListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.EntityListeners;





@Entity
@EntityListeners(AuditListener.class)
@Table(name="material")
//对应的表为:material
public class Material{
  private static final Logger LOGGER = LoggerFactory.getLogger(Material.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long materialID;
  //varchar(50) 
  @NotNull
  private String materialName;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unitID")
  @JsonIgnore
  private Materialunit  materialunit;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  @JsonIgnore
  private Materialclass  materialclass;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modelID")
  @JsonIgnore
  private Materialmodel  materialmodel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brandID")
  @JsonIgnore
  private Materialbrand  materialbrand;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specID")
  @JsonIgnore
  private Materialspec  materialspec;

  //关系实体创建完毕


  public void setMaterialID(Long materialID){
    this.materialID = materialID;
  }


  public Long getMaterialID(){
    return this.materialID;
  }


  public void setMaterialName(String materialName){
    this.materialName = materialName;
  }


  public String getMaterialName(){
    return this.materialName;
  }
  public Materialunit getMaterialunit() {
    return this.materialunit;
  }

  public void setMaterialunit(Materialunit materialunit) {
    this.materialunit = materialunit;
  }

  public Materialclass getMaterialclass() {
    return this.materialclass;
  }

  public void setMaterialclass(Materialclass materialclass) {
    this.materialclass = materialclass;
  }

  public Materialmodel getMaterialmodel() {
    return this.materialmodel;
  }

  public void setMaterialmodel(Materialmodel materialmodel) {
    this.materialmodel = materialmodel;
  }

  public Materialbrand getMaterialbrand() {
    return this.materialbrand;
  }

  public void setMaterialbrand(Materialbrand materialbrand) {
    this.materialbrand = materialbrand;
  }

  public Materialspec getMaterialspec() {
    return this.materialspec;
  }

  public void setMaterialspec(Materialspec materialspec) {
    this.materialspec = materialspec;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("materialID=%s,materialName=%s",this.materialID,this.materialName);
  }
  private final static String FIELD_MATERIALID="materialID";
  public static String getFieldmaterialID() {
    return FIELD_MATERIALID;
  }

  private final static String FIELD_MATERIALNAME="materialName";
  public static String getFieldmaterialName() {
    return FIELD_MATERIALNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Material)) return false;
    Material material= (Material)o;
    return materialID!= null && materialID.equals(material.materialID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
