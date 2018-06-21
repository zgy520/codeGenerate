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
@Table(name="log_content")
//对应的表为:log_content
public class Log_content{
  private static final Logger LOGGER = LoggerFactory.getLogger(Log_content.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long contentID;
  //varchar(50) 字段名称
  private String fldName;
  //varchar(2048) 字段旧值
  private String oldValue;
  //varchar(2048) 字段新值
  private String newValue;
  //varchar(50) 字段注释
  private String fldComment;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "logID")
  @JsonIgnore
  private Log  log;

  //关系实体创建完毕


  public void setContentID(Long contentID){
    this.contentID = contentID;
  }


  public Long getContentID(){
    return this.contentID;
  }


  public void setFldName(String fldName){
    this.fldName = fldName;
  }


  public String getFldName(){
    return this.fldName;
  }


  public void setOldValue(String oldValue){
    this.oldValue = oldValue;
  }


  public String getOldValue(){
    return this.oldValue;
  }


  public void setNewValue(String newValue){
    this.newValue = newValue;
  }


  public String getNewValue(){
    return this.newValue;
  }


  public void setFldComment(String fldComment){
    this.fldComment = fldComment;
  }


  public String getFldComment(){
    return this.fldComment;
  }
  public Log getLog() {
    return this.log;
  }

  public void setLog(Log log) {
    this.log = log;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("contentID=%s,fldName=%s,oldValue=%s,newValue=%s,fldComment=%s",this.contentID,this.fldName,this.oldValue,this.newValue,this.fldComment);
  }
  private final static String FIELD_CONTENTID="contentID";
  public static String getFieldcontentID() {
    return FIELD_CONTENTID;
  }

  private final static String FIELD_FLDNAME="fldName";
  public static String getFieldfldName() {
    return FIELD_FLDNAME;
  }

  private final static String FIELD_OLDVALUE="oldValue";
  public static String getFieldoldValue() {
    return FIELD_OLDVALUE;
  }

  private final static String FIELD_NEWVALUE="newValue";
  public static String getFieldnewValue() {
    return FIELD_NEWVALUE;
  }

  private final static String FIELD_FLDCOMMENT="fldComment";
  public static String getFieldfldComment() {
    return FIELD_FLDCOMMENT;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Log_content)) return false;
    Log_content log_content= (Log_content)o;
    return contentID!= null && contentID.equals(log_content.contentID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
