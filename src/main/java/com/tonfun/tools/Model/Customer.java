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
@Table(name="customer")
//对应的表为:customer
public class Customer{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long customerID;
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
  private String accountBank;
  //varchar(20) 
  private String accountNumber;
  //varchar(20) 
  private String taxNumber;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "customer")
  private Set<Customerlinkman>  customerlinkmans = new HashSet<>();

  //关系实体创建完毕


  public void setCustomerID(Long customerID){
    this.customerID = customerID;
  }


  public Long getCustomerID(){
    return this.customerID;
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
  public Set<Customerlinkman> getCustomerlinkman() {
    return this.customerlinkmans;
  }

  public void setCustomerlinkman(Set<Customerlinkman> customerlinkmans) {
    this.customerlinkmans = customerlinkmans;
  }

  @Override
  public String toString() {
    return String.format("customerID=%s,fullName=%s,shortName=%s,address=%s,accountBank=%s,accountNumber=%s,taxNumber=%s",this.customerID,this.fullName,this.shortName,this.address,this.accountBank,this.accountNumber,this.taxNumber);
  }
  private final static String FIELD_CUSTOMERID="customerID";
  public static String getFieldcustomerID() {
    return FIELD_CUSTOMERID;
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
    if(!(o instanceof Customer)) return false;
    Customer customer= (Customer)o;
    return customerID!= null && customerID.equals(customer.customerID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
