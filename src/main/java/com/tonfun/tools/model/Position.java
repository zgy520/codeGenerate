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
@Table(name="position")
//对应的表为:position
public class Position{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long posID;
  //varchar(50) 
  @NotNull
  private String posName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "position")
  private Set<Employee>  employees = new HashSet<>();

  //关系实体创建完毕


  public void setPosID(Long posID){
    this.posID = posID;
  }


  public Long getPosID(){
    return this.posID;
  }


  public void setPosName(String posName){
    this.posName = posName;
  }


  public String getPosName(){
    return this.posName;
  }
}
