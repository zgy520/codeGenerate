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
@Table(name="customerlinkman")
//对应的表为:customerlinkman
public class Customerlinkman{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long linkmanID;
  //bigint(20) 
  @NotNull
  private Long customerID;
  //varchar(50) 
  @NotNull
  private String linkman;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //bigint(20) 
  private Long userID;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customerID")
  private Customer  customer;

  //关系实体创建完毕


  public void setLinkmanID(Long linkmanID){
    this.linkmanID = linkmanID;
  }


  public Long getLinkmanID(){
    return this.linkmanID;
  }


  public void setCustomerID(Long customerID){
    this.customerID = customerID;
  }


  public Long getCustomerID(){
    return this.customerID;
  }


  public void setLinkman(String linkman){
    this.linkman = linkman;
  }


  public String getLinkman(){
    return this.linkman;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }


  public void setUserID(Long userID){
    this.userID = userID;
  }


  public Long getUserID(){
    return this.userID;
  }
  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

}
