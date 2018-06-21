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
@Table(name="user")
//对应的表为:user
public class User{
  private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long userID;
  //char(50) 登录名
  @NotNull
  private String loginName;
  //varchar(50) 用户姓名
  @NotNull
  private String userName;
  //varchar(100) 登录密码
  @NotNull
  private String password;
  //varchar(200) 描述
  private String description;
  //tinyint(1) 启用状态
  @NotNull
  private int enabledState;
  //bigint(20) 登录次数
  private Long loginCount;
  //int(11) 
  private int failedCount;
  //datetime 最后登录失败时间
  private LocalDateTime loginFailedLastTime;
  //tinyint(1) 是否可见
  @NotNull
  private int visible;
  //date 有效期
  private LocalDate deadline;
  //varchar(50) 创建者
  private String creator;
  //datetime 创建时间
  private LocalDateTime createTime;
  //varchar(50) 更新者
  private String updator;
  //datetime 更新时间
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private Set<User_shortcutmenu>  user_shortcutmenus = new HashSet<>();

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_orguser",joinColumns = {@JoinColumn(name="userID")},inverseJoinColumns = {@JoinColumn(name="orgID")})
  @JsonIgnore
  private Set<Organization> map_orguser_organizations;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_roleuser",joinColumns = {@JoinColumn(name="userID")},inverseJoinColumns = {@JoinColumn(name="roleID")})
  @JsonIgnore
  private Set<Role> map_roleuser_roles;
  //关系实体创建完毕


  public void setUserID(Long userID){
    this.userID = userID;
  }


  public Long getUserID(){
    return this.userID;
  }


  public void setLoginName(String loginName){
    this.loginName = loginName;
  }


  public String getLoginName(){
    return this.loginName;
  }


  public void setUserName(String userName){
    this.userName = userName;
  }


  public String getUserName(){
    return this.userName;
  }


  public void setPassword(String password){
    this.password = password;
  }


  public String getPassword(){
    return this.password;
  }


  public void setDescription(String description){
    this.description = description;
  }


  public String getDescription(){
    return this.description;
  }


  public void setEnabledState(int enabledState){
    this.enabledState = enabledState;
  }


  public int getEnabledState(){
    return this.enabledState;
  }


  public void setLoginCount(Long loginCount){
    this.loginCount = loginCount;
  }


  public Long getLoginCount(){
    return this.loginCount;
  }


  public void setFailedCount(int failedCount){
    this.failedCount = failedCount;
  }


  public int getFailedCount(){
    return this.failedCount;
  }


  public void setLoginFailedLastTime(LocalDateTime loginFailedLastTime){
    this.loginFailedLastTime = loginFailedLastTime;
  }


  public LocalDateTime getLoginFailedLastTime(){
    return this.loginFailedLastTime;
  }


  public void setVisible(int visible){
    this.visible = visible;
  }


  public int getVisible(){
    return this.visible;
  }


  public void setDeadline(LocalDate deadline){
    this.deadline = deadline;
  }


  public LocalDate getDeadline(){
    return this.deadline;
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
  public Set<User_shortcutmenu> getUser_shortcutmenu() {
    return this.user_shortcutmenus;
  }

  public void setUser_shortcutmenu(Set<User_shortcutmenu> user_shortcutmenus) {
    this.user_shortcutmenus = user_shortcutmenus;
  }

  public Set<Organization> getmap_orguser_Organizations() {
    return this.map_orguser_organizations;
  }

  public void setmap_orguser_Organizations(Set<Organization> map_orguser_organizations) {
    this.map_orguser_organizations = map_orguser_organizations;
  }

  public Set<Role> getmap_roleuser_Roles() {
    return this.map_roleuser_roles;
  }

  public void setmap_roleuser_Roles(Set<Role> map_roleuser_roles) {
    this.map_roleuser_roles = map_roleuser_roles;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("userID=%s,loginName=%s,userName=%s,password=%s,description=%s,enabledState=%s,loginCount=%s,failedCount=%s,loginFailedLastTime=%s,visible=%s,deadline=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.userID,this.loginName,this.userName,this.password,this.description,this.enabledState,this.loginCount,this.failedCount,this.loginFailedLastTime,this.visible,this.deadline,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_USERID="userID";
  public static String getFielduserID() {
    return FIELD_USERID;
  }

  private final static String FIELD_LOGINNAME="loginName";
  public static String getFieldloginName() {
    return FIELD_LOGINNAME;
  }

  private final static String FIELD_USERNAME="userName";
  public static String getFielduserName() {
    return FIELD_USERNAME;
  }

  private final static String FIELD_PASSWORD="password";
  public static String getFieldpassword() {
    return FIELD_PASSWORD;
  }

  private final static String FIELD_DESCRIPTION="description";
  public static String getFielddescription() {
    return FIELD_DESCRIPTION;
  }

  private final static String FIELD_ENABLEDSTATE="enabledState";
  public static String getFieldenabledState() {
    return FIELD_ENABLEDSTATE;
  }

  private final static String FIELD_LOGINCOUNT="loginCount";
  public static String getFieldloginCount() {
    return FIELD_LOGINCOUNT;
  }

  private final static String FIELD_FAILEDCOUNT="failedCount";
  public static String getFieldfailedCount() {
    return FIELD_FAILEDCOUNT;
  }

  private final static String FIELD_LOGINFAILEDLASTTIME="loginFailedLastTime";
  public static String getFieldloginFailedLastTime() {
    return FIELD_LOGINFAILEDLASTTIME;
  }

  private final static String FIELD_VISIBLE="visible";
  public static String getFieldvisible() {
    return FIELD_VISIBLE;
  }

  private final static String FIELD_DEADLINE="deadline";
  public static String getFielddeadline() {
    return FIELD_DEADLINE;
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
    if(!(o instanceof User)) return false;
    User user= (User)o;
    return userID!= null && userID.equals(user.userID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
