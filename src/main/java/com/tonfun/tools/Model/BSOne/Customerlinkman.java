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
@Table(name="customerlinkman")
//对应的表为:customerlinkman
public class Customerlinkman{
  private static final Logger LOGGER = LoggerFactory.getLogger(Customerlinkman.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long linkmanID;
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
  @JsonIgnore
  private Customer  customer;

  //关系实体创建完毕


  public void setLinkmanID(Long linkmanID){
    this.linkmanID = linkmanID;
  }


  public Long getLinkmanID(){
    return this.linkmanID;
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

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("linkmanID=%s,linkman=%s,phoneNumber=%s,userID=%s",this.linkmanID,this.linkman,this.phoneNumber,this.userID);
  }
  private final static String FIELD_LINKMANID="linkmanID";
  public static String getFieldlinkmanID() {
    return FIELD_LINKMANID;
  }

  private final static String FIELD_LINKMAN="linkman";
  public static String getFieldlinkman() {
    return FIELD_LINKMAN;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  private final static String FIELD_USERID="userID";
  public static String getFielduserID() {
    return FIELD_USERID;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Customerlinkman)) return false;
    Customerlinkman customerlinkman= (Customerlinkman)o;
    return linkmanID!= null && linkmanID.equals(customerlinkman.linkmanID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
