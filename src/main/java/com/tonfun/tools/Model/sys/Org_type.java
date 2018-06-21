package com.tonfun.tools.Model.sys;
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
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.EntityListeners;





@Entity
@EntityListeners(AuditListener.class)
@Table(name="org_type")
//对应的表为:org_type
public class Org_type{
  private static final Logger LOGGER = LoggerFactory.getLogger(Org_type.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long orgTypeID;
  //varchar(50) 机构类型
  @NotNull
  private String orgType;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "org_type")
  @JsonIgnore
  private Set<Organization>  organizations = new HashSet<>();

  //关系实体创建完毕


  public void setOrgTypeID(Long orgTypeID){
    this.orgTypeID = orgTypeID;
  }


  public Long getOrgTypeID(){
    return this.orgTypeID;
  }


  public void setOrgType(String orgType){
    this.orgType = orgType;
  }


  public String getOrgType(){
    return this.orgType;
  }
  public Set<Organization> getOrganization() {
    return this.organizations;
  }

  public void setOrganization(Set<Organization> organizations) {
    this.organizations = organizations;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("orgTypeID=%s,orgType=%s",this.orgTypeID,this.orgType);
  }
  private final static String FIELD_ORGTYPEID="orgTypeID";
  public static String getFieldorgTypeID() {
    return FIELD_ORGTYPEID;
  }

  private final static String FIELD_ORGTYPE="orgType";
  public static String getFieldorgType() {
    return FIELD_ORGTYPE;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Org_type)) return false;
    Org_type org_type= (Org_type)o;
    return orgTypeID!= null && orgTypeID.equals(org_type.orgTypeID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
