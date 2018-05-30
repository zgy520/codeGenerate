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
@Table(name="logisticscompany")
//对应的表为:logisticscompany
public class Logisticscompany{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long companyID;
  //varchar(50) 
  @NotNull
  private String fullName;
  //varchar(6) 
  @NotNull
  private String shortName;
  //varchar(50) 
  @NotNull
  private String address;
  //varchar(50) 
  @NotNull
  private String linkman;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //varchar(50) 
  private String accountBank;
  //varchar(20) 
  private String accountNumber;
  //varchar(20) 
  private String taxNumber;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "logisticscompany")
  private Set<Logisticsvehicle>  logisticsvehicles = new HashSet<>();

  @OneToMany(mappedBy = "logisticscompany")
  private Set<Logisticsdriver>  logisticsdrivers = new HashSet<>();

  //关系实体创建完毕


  public void setCompanyID(Long companyID){
    this.companyID = companyID;
  }


  public Long getCompanyID(){
    return this.companyID;
  }


  public void setFullName(String fullName){
    this.fullName = fullName;
  }


  public String getFullName(){
    return this.fullName;
  }


  public void setShortName(String shortName){
    this.shortName = shortName;
  }


  public String getShortName(){
    return this.shortName;
  }


  public void setAddress(String address){
    this.address = address;
  }


  public String getAddress(){
    return this.address;
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


  public void setAccountBank(String accountBank){
    this.accountBank = accountBank;
  }


  public String getAccountBank(){
    return this.accountBank;
  }


  public void setAccountNumber(String accountNumber){
    this.accountNumber = accountNumber;
  }


  public String getAccountNumber(){
    return this.accountNumber;
  }


  public void setTaxNumber(String taxNumber){
    this.taxNumber = taxNumber;
  }


  public String getTaxNumber(){
    return this.taxNumber;
  }
  public Set<Logisticsvehicle> getLogisticsvehicle() {
    return this.logisticsvehicles;
  }

  public void setLogisticsvehicle(Set<Logisticsvehicle> logisticsvehicles) {
    this.logisticsvehicles = logisticsvehicles;
  }

  public Set<Logisticsdriver> getLogisticsdriver() {
    return this.logisticsdrivers;
  }

  public void setLogisticsdriver(Set<Logisticsdriver> logisticsdrivers) {
    this.logisticsdrivers = logisticsdrivers;
  }

  @Override
  public String toString() {
    return String.format("companyID=%s,fullName=%s,shortName=%s,address=%s,linkman=%s,phoneNumber=%s,accountBank=%s,accountNumber=%s,taxNumber=%s",this.companyID,this.fullName,this.shortName,this.address,this.linkman,this.phoneNumber,this.accountBank,this.accountNumber,this.taxNumber);
  }
  private final static String FIELD_COMPANYID="companyID";
  public static String getFieldcompanyID() {
    return FIELD_COMPANYID;
  }

  private final static String FIELD_FULLNAME="fullName";
  public static String getFieldfullName() {
    return FIELD_FULLNAME;
  }

  private final static String FIELD_SHORTNAME="shortName";
  public static String getFieldshortName() {
    return FIELD_SHORTNAME;
  }

  private final static String FIELD_ADDRESS="address";
  public static String getFieldaddress() {
    return FIELD_ADDRESS;
  }

  private final static String FIELD_LINKMAN="linkman";
  public static String getFieldlinkman() {
    return FIELD_LINKMAN;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  private final static String FIELD_ACCOUNTBANK="accountBank";
  public static String getFieldaccountBank() {
    return FIELD_ACCOUNTBANK;
  }

  private final static String FIELD_ACCOUNTNUMBER="accountNumber";
  public static String getFieldaccountNumber() {
    return FIELD_ACCOUNTNUMBER;
  }

  private final static String FIELD_TAXNUMBER="taxNumber";
  public static String getFieldtaxNumber() {
    return FIELD_TAXNUMBER;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Logisticscompany)) return false;
    Logisticscompany logisticscompany= (Logisticscompany)o;
    return companyID!= null && companyID.equals(logisticscompany.companyID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
