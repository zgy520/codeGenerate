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
@Table(name="diluent")
//对应的表为:diluent
public class Diluent{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long diluentID;
  //varchar(20) 
  @NotNull
  private String diluentName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "diluent")
  private Set<Mechanicalimpuritiesrecord>  mechanicalimpuritiesrecords = new HashSet<>();

  //关系实体创建完毕


  public void setDiluentID(Long diluentID){
    this.diluentID = diluentID;
  }


  public Long getDiluentID(){
    return this.diluentID;
  }


  public void setDiluentName(String diluentName){
    this.diluentName = diluentName;
  }


  public String getDiluentName(){
    return this.diluentName;
  }
  public Set<Mechanicalimpuritiesrecord> getMechanicalimpuritiesrecord() {
    return this.mechanicalimpuritiesrecords;
  }

  public void setMechanicalimpuritiesrecord(Set<Mechanicalimpuritiesrecord> mechanicalimpuritiesrecords) {
    this.mechanicalimpuritiesrecords = mechanicalimpuritiesrecords;
  }

}
