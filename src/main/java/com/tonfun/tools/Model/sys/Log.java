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
@Table(name="log")
//对应的表为:log
public class Log{
  private static final Logger LOGGER = LoggerFactory.getLogger(Log.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long logID;
  //datetime 日志时间
  private LocalDateTime logTime;
  //varchar(4000) 日志内容
  private String message;
  //bigint(20) 用户ID
  private Long userID;
  //char(50) 登录名
  private String loginName;
  //varchar(50) 用户姓名
  private String userName;
  //varchar(1024) 操作
  private String operation;
  //int(11) 类型
  private int type;
  //varchar(50) 表名称
  private String tblName;
  //varchar(50) 表注释
  private String tblComment;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "log")
  @JsonIgnore
  private Set<Log_content>  log_contents = new HashSet<>();

  //关系实体创建完毕


  public void setLogID(Long logID){
    this.logID = logID;
  }


  public Long getLogID(){
    return this.logID;
  }


  public void setLogTime(LocalDateTime logTime){
    this.logTime = logTime;
  }


  public LocalDateTime getLogTime(){
    return this.logTime;
  }


  public void setMessage(String message){
    this.message = message;
  }


  public String getMessage(){
    return this.message;
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


  public void setOperation(String operation){
    this.operation = operation;
  }


  public String getOperation(){
    return this.operation;
  }


  public void setType(int type){
    this.type = type;
  }


  public int getType(){
    return this.type;
  }


  public void setTblName(String tblName){
    this.tblName = tblName;
  }


  public String getTblName(){
    return this.tblName;
  }


  public void setTblComment(String tblComment){
    this.tblComment = tblComment;
  }


  public String getTblComment(){
    return this.tblComment;
  }
  public Set<Log_content> getLog_content() {
    return this.log_contents;
  }

  public void setLog_content(Set<Log_content> log_contents) {
    this.log_contents = log_contents;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("logID=%s,logTime=%s,message=%s,userID=%s,loginName=%s,userName=%s,operation=%s,type=%s,tblName=%s,tblComment=%s",this.logID,this.logTime,this.message,this.userID,this.loginName,this.userName,this.operation,this.type,this.tblName,this.tblComment);
  }
  private final static String FIELD_LOGID="logID";
  public static String getFieldlogID() {
    return FIELD_LOGID;
  }

  private final static String FIELD_LOGTIME="logTime";
  public static String getFieldlogTime() {
    return FIELD_LOGTIME;
  }

  private final static String FIELD_MESSAGE="message";
  public static String getFieldmessage() {
    return FIELD_MESSAGE;
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

  private final static String FIELD_OPERATION="operation";
  public static String getFieldoperation() {
    return FIELD_OPERATION;
  }

  private final static String FIELD_TYPE="type";
  public static String getFieldtype() {
    return FIELD_TYPE;
  }

  private final static String FIELD_TBLNAME="tblName";
  public static String getFieldtblName() {
    return FIELD_TBLNAME;
  }

  private final static String FIELD_TBLCOMMENT="tblComment";
  public static String getFieldtblComment() {
    return FIELD_TBLCOMMENT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Log)) return false;
    Log log= (Log)o;
    return logID!= null && logID.equals(log.logID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
