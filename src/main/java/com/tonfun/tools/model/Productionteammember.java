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
@Table(name="productionteammember")
//对应的表为:productionteammember
public class Productionteammember{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long memberID;
  //bigint(20) 
  @NotNull
  private Long teamID;
  //varchar(50) 
  @NotNull
  private String posName;
  //varchar(50) 
  @NotNull
  private String employeeName;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "teamID")
  private Productionteam  productionteam;

  //关系实体创建完毕


  public void setMemberID(Long memberID){
    this.memberID = memberID;
  }


  public Long getMemberID(){
    return this.memberID;
  }


  public void setTeamID(Long teamID){
    this.teamID = teamID;
  }


  public Long getTeamID(){
    return this.teamID;
  }


  public void setPosName(String posName){
    this.posName = posName;
  }


  public String getPosName(){
    return this.posName;
  }


  public void setEmployeeName(String employeeName){
    this.employeeName = employeeName;
  }


  public String getEmployeeName(){
    return this.employeeName;
  }
  public Productionteam getProductionteam() {
    return this.productionteam;
  }

  public void setProductionteam(Productionteam productionteam) {
    this.productionteam = productionteam;
  }

}
