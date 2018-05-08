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
@Table(name="material")
//对应的表为:material
public class Material{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long materialID;
  //bigint(20) 
  @NotNull
  private Long brandID;
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
  private Long classID;
  //varchar(50) 
  @NotNull
  private String materialName;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specID")
  private Materialspec  materialspec;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unitID")
  private Materialunit  materialunit;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modelID")
  private Materialmodel  materialmodel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  private Materialclass  materialclass;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brandID")
  private Materialbrand  materialbrand;

  //关系实体创建完毕


  public void setMaterialID(Long materialID){
    this.materialID = materialID;
  }


  public Long getMaterialID(){
    return this.materialID;
  }


  public void setBrandID(Long brandID){
    this.brandID = brandID;
  }


  public Long getBrandID(){
    return this.brandID;
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


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }


  public void setMaterialName(String materialName){
    this.materialName = materialName;
  }


  public String getMaterialName(){
    return this.materialName;
  }
  public Materialspec getMaterialspec() {
    return this.materialspec;
  }

  public void setMaterialspec(Materialspec materialspec) {
    this.materialspec = materialspec;
  }

  public Materialunit getMaterialunit() {
    return this.materialunit;
  }

  public void setMaterialunit(Materialunit materialunit) {
    this.materialunit = materialunit;
  }

  public Materialmodel getMaterialmodel() {
    return this.materialmodel;
  }

  public void setMaterialmodel(Materialmodel materialmodel) {
    this.materialmodel = materialmodel;
  }

  public Materialclass getMaterialclass() {
    return this.materialclass;
  }

  public void setMaterialclass(Materialclass materialclass) {
    this.materialclass = materialclass;
  }

  public Materialbrand getMaterialbrand() {
    return this.materialbrand;
  }

  public void setMaterialbrand(Materialbrand materialbrand) {
    this.materialbrand = materialbrand;
  }

}
