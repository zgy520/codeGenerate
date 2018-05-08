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
@Table(name="productionteam")
//对应的表为:productionteam
public class Productionteam{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long teamID;
  //varchar(50) 
  @NotNull
  private String teamName;
  //varchar(20) 创建者
  @NotNull
  private String creator;
  //datetime 创建时间
  private LocalDateTime createTime;
  //varchar(20) 更新着
  private String updator;
  //datetime 更新时间
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "productionteam")
  private Set<Productionteammember>  productionteammembers = new HashSet<>();

  @OneToMany(mappedBy = "productionteam")
  private Set<Productionorder>  productionorders = new HashSet<>();

  //关系实体创建完毕


  public void setTeamID(Long teamID){
    this.teamID = teamID;
  }


  public Long getTeamID(){
    return this.teamID;
  }


  public void setTeamName(String teamName){
    this.teamName = teamName;
  }


  public String getTeamName(){
    return this.teamName;
  }


  public void setCreator(String creator){
    this.creator = creator;
  }


  public String getCreator(){
    return this.creator;
  }


  public void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
  }


  public LocalDateTime getCreateTime(){
    return this.createTime;
  }


  public void setUpdator(String updator){
    this.updator = updator;
  }


  public String getUpdator(){
    return this.updator;
  }


  public void setUpdateTime(LocalDateTime updateTime){
    this.updateTime = updateTime;
  }


  public LocalDateTime getUpdateTime(){
    return this.updateTime;
  }
  public Set<Productionteammember> getProductionteammember() {
    return this.productionteammembers;
  }

  public void setProductionteammember(Set<Productionteammember> productionteammembers) {
    this.productionteammembers = productionteammembers;
  }

  public Set<Productionorder> getProductionorder() {
    return this.productionorders;
  }

  public void setProductionorder(Set<Productionorder> productionorders) {
    this.productionorders = productionorders;
  }

}
