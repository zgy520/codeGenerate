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
@Table(name="role")
//对应的表为:role
public class Role{
  private static final Logger LOGGER = LoggerFactory.getLogger(Role.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long roleID;
  //varchar(50) 角色名称
  @NotNull
  private String roleName;
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
  //tinyint(1) 是否可见
  @NotNull
  private int visible;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "role")
  @JsonIgnore
  private Set<Map_rolemenubutton>  map_rolemenubuttons = new HashSet<>();

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_rolemenucol",joinColumns = {@JoinColumn(name="roleID")},inverseJoinColumns = {@JoinColumn(name="menuID")})
  @JsonIgnore
  private Set<Menu> map_rolemenucol_menus;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_roleuser",joinColumns = {@JoinColumn(name="roleID")},inverseJoinColumns = {@JoinColumn(name="userID")})
  @JsonIgnore
  private Set<User> map_roleuser_users;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_orgrole",joinColumns = {@JoinColumn(name="roleID")},inverseJoinColumns = {@JoinColumn(name="orgID")})
  @JsonIgnore
  private Set<Organization> map_orgrole_organizations;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_rolemenu",joinColumns = {@JoinColumn(name="roleID")},inverseJoinColumns = {@JoinColumn(name="menuID")})
  @JsonIgnore
  private Set<Menu> map_rolemenu_menus;
  //关系实体创建完毕


  public void setRoleID(Long roleID){
    this.roleID = roleID;
  }


  public Long getRoleID(){
    return this.roleID;
  }


  public void setRoleName(String roleName){
    this.roleName = roleName;
  }


  public String getRoleName(){
    return this.roleName;
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


  public void setVisible(int visible){
    this.visible = visible;
  }


  public int getVisible(){
    return this.visible;
  }
  public Set<Map_rolemenubutton> getMap_rolemenubutton() {
    return this.map_rolemenubuttons;
  }

  public void setMap_rolemenubutton(Set<Map_rolemenubutton> map_rolemenubuttons) {
    this.map_rolemenubuttons = map_rolemenubuttons;
  }

  public Set<Menu> getmap_rolemenucol_Menus() {
    return this.map_rolemenucol_menus;
  }

  public void setmap_rolemenucol_Menus(Set<Menu> map_rolemenucol_menus) {
    this.map_rolemenucol_menus = map_rolemenucol_menus;
  }

  public Set<User> getmap_roleuser_Users() {
    return this.map_roleuser_users;
  }

  public void setmap_roleuser_Users(Set<User> map_roleuser_users) {
    this.map_roleuser_users = map_roleuser_users;
  }

  public Set<Organization> getmap_orgrole_Organizations() {
    return this.map_orgrole_organizations;
  }

  public void setmap_orgrole_Organizations(Set<Organization> map_orgrole_organizations) {
    this.map_orgrole_organizations = map_orgrole_organizations;
  }

  public Set<Menu> getmap_rolemenu_Menus() {
    return this.map_rolemenu_menus;
  }

  public void setmap_rolemenu_Menus(Set<Menu> map_rolemenu_menus) {
    this.map_rolemenu_menus = map_rolemenu_menus;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("roleID=%s,roleName=%s,serial=%s,description=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s,visible=%s",this.roleID,this.roleName,this.serial,this.description,this.creator,this.createTime,this.updator,this.updateTime,this.visible);
  }
  private final static String FIELD_ROLEID="roleID";
  public static String getFieldroleID() {
    return FIELD_ROLEID;
  }

  private final static String FIELD_ROLENAME="roleName";
  public static String getFieldroleName() {
    return FIELD_ROLENAME;
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

  private final static String FIELD_VISIBLE="visible";
  public static String getFieldvisible() {
    return FIELD_VISIBLE;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Role)) return false;
    Role role= (Role)o;
    return roleID!= null && roleID.equals(role.roleID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
