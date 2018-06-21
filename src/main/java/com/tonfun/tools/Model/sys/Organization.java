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
@Table(name="organization")
//对应的表为:organization
public class Organization{
  private static final Logger LOGGER = LoggerFactory.getLogger(Organization.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long orgID;
  //varchar(50) 机构名称
  @NotNull
  private String orgName;
  //bigint(20) 序号
  private Long serial;
  //varchar(200) 描述
  private String description;
  //varchar(50) 创建者
  private String creator;
  //datetime 创建时间
  private LocalDateTime createTime;
  //varchar(50) 更新者
  private String updator;
  //datetime 更新时间
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orgTypeID")
  @JsonIgnore
  private Org_type  org_type;

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_orguser",joinColumns = {@JoinColumn(name="orgID")},inverseJoinColumns = {@JoinColumn(name="userID")})
  @JsonIgnore
  private Set<User> map_orguser_users;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_orgrole",joinColumns = {@JoinColumn(name="orgID")},inverseJoinColumns = {@JoinColumn(name="roleID")})
  @JsonIgnore
  private Set<Role> map_orgrole_roles;
  //关系实体创建完毕


  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }


  public Long getOrgID(){
    return this.orgID;
  }


  public void setOrgName(String orgName){
    this.orgName = orgName;
  }


  public String getOrgName(){
    return this.orgName;
  }


  public void setSerial(Long serial){
    this.serial = serial;
  }


  public Long getSerial(){
    return this.serial;
  }


  public void setDescription(String description){
    this.description = description;
  }


  public String getDescription(){
    return this.description;
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
  public Org_type getOrg_type() {
    return this.org_type;
  }

  public void setOrg_type(Org_type org_type) {
    this.org_type = org_type;
  }

  public Set<User> getmap_orguser_Users() {
    return this.map_orguser_users;
  }

  public void setmap_orguser_Users(Set<User> map_orguser_users) {
    this.map_orguser_users = map_orguser_users;
  }

  public Set<Role> getmap_orgrole_Roles() {
    return this.map_orgrole_roles;
  }

  public void setmap_orgrole_Roles(Set<Role> map_orgrole_roles) {
    this.map_orgrole_roles = map_orgrole_roles;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("orgID=%s,orgName=%s,serial=%s,description=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.orgID,this.orgName,this.serial,this.description,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_ORGID="orgID";
  public static String getFieldorgID() {
    return FIELD_ORGID;
  }

  private final static String FIELD_ORGNAME="orgName";
  public static String getFieldorgName() {
    return FIELD_ORGNAME;
  }

  private final static String FIELD_SERIAL="serial";
  public static String getFieldserial() {
    return FIELD_SERIAL;
  }

  private final static String FIELD_DESCRIPTION="description";
  public static String getFielddescription() {
    return FIELD_DESCRIPTION;
  }

  private final static String FIELD_CREATOR="creator";
  public static String getFieldcreator() {
    return FIELD_CREATOR;
  }

  private final static String FIELD_CREATETIME="createTime";
  public static String getFieldcreateTime() {
    return FIELD_CREATETIME;
  }

  private final static String FIELD_UPDATOR="updator";
  public static String getFieldupdator() {
    return FIELD_UPDATOR;
  }

  private final static String FIELD_UPDATETIME="updateTime";
  public static String getFieldupdateTime() {
    return FIELD_UPDATETIME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Organization)) return false;
    Organization organization= (Organization)o;
    return orgID!= null && orgID.equals(organization.orgID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
