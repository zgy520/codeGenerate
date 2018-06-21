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
@Table(name="login_history")
//对应的表为:login_history
public class Login_history{
  private static final Logger LOGGER = LoggerFactory.getLogger(Login_history.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long histRecID;
  //bigint(20) 用户ID
  private Long userID;
  //char(50) 登录名
  private String loginName;
  //varchar(50) 用户姓名
  private String userName;
  //bigint(20) 角色ID
  private Long roleID;
  //varchar(50) 角色名称
  private String roleName;
  //varchar(200) 登录机器名称
  private String hostName;
  //varchar(50) 登录机器IP
  private String hostIP;
  //varchar(200) 登录城市
  private String loginCity;
  //datetime 登录时间
  private LocalDateTime loginTime;
  //varchar(50) 创建者
  private String creator;
  //datetime 创建时间
  private LocalDateTime createTime;
  //varchar(50) 更新者
  private String updator;
  //datetime 更新时间
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  //关系实体创建完毕


  public void setHistRecID(Long histRecID){
    this.histRecID = histRecID;
  }


  public Long getHistRecID(){
    return this.histRecID;
  }


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


  public void setHostName(String hostName){
    this.hostName = hostName;
  }


  public String getHostName(){
    return this.hostName;
  }


  public void setHostIP(String hostIP){
    this.hostIP = hostIP;
  }


  public String getHostIP(){
    return this.hostIP;
  }


  public void setLoginCity(String loginCity){
    this.loginCity = loginCity;
  }


  public String getLoginCity(){
    return this.loginCity;
  }


  public void setLoginTime(LocalDateTime loginTime){
    this.loginTime = loginTime;
  }


  public LocalDateTime getLoginTime(){
    return this.loginTime;
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
  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("histRecID=%s,userID=%s,loginName=%s,userName=%s,roleID=%s,roleName=%s,hostName=%s,hostIP=%s,loginCity=%s,loginTime=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.histRecID,this.userID,this.loginName,this.userName,this.roleID,this.roleName,this.hostName,this.hostIP,this.loginCity,this.loginTime,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_HISTRECID="histRecID";
  public static String getFieldhistRecID() {
    return FIELD_HISTRECID;
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

  private final static String FIELD_ROLEID="roleID";
  public static String getFieldroleID() {
    return FIELD_ROLEID;
  }

  private final static String FIELD_ROLENAME="roleName";
  public static String getFieldroleName() {
    return FIELD_ROLENAME;
  }

  private final static String FIELD_HOSTNAME="hostName";
  public static String getFieldhostName() {
    return FIELD_HOSTNAME;
  }

  private final static String FIELD_HOSTIP="hostIP";
  public static String getFieldhostIP() {
    return FIELD_HOSTIP;
  }

  private final static String FIELD_LOGINCITY="loginCity";
  public static String getFieldloginCity() {
    return FIELD_LOGINCITY;
  }

  private final static String FIELD_LOGINTIME="loginTime";
  public static String getFieldloginTime() {
    return FIELD_LOGINTIME;
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
    if(!(o instanceof Login_history)) return false;
    Login_history login_history= (Login_history)o;
    return histRecID!= null && histRecID.equals(login_history.histRecID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
