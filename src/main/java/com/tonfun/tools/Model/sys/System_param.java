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
@Table(name="system_param")
//对应的表为:system_param
public class System_param{
  private static final Logger LOGGER = LoggerFactory.getLogger(System_param.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long paramID;
  //varchar(20) 参数编码
  @NotNull
  private String paramCode;
  //varchar(200) 参数值
  @NotNull
  private String paramValue;
  //tinyint(1) 可编辑状态
  @NotNull
  private int isEdited;
  //varchar(200) 备注
  private String remark;
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


  public void setParamID(Long paramID){
    this.paramID = paramID;
  }


  public Long getParamID(){
    return this.paramID;
  }


  public void setParamCode(String paramCode){
    this.paramCode = paramCode;
  }


  public String getParamCode(){
    return this.paramCode;
  }


  public void setParamValue(String paramValue){
    this.paramValue = paramValue;
  }


  public String getParamValue(){
    return this.paramValue;
  }


  public void setIsEdited(int isEdited){
    this.isEdited = isEdited;
  }


  public int getIsEdited(){
    return this.isEdited;
  }


  public void setRemark(String remark){
    this.remark = remark;
  }


  public String getRemark(){
    return this.remark;
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
    return String.format("paramID=%s,paramCode=%s,paramValue=%s,isEdited=%s,remark=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.paramID,this.paramCode,this.paramValue,this.isEdited,this.remark,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_PARAMID="paramID";
  public static String getFieldparamID() {
    return FIELD_PARAMID;
  }

  private final static String FIELD_PARAMCODE="paramCode";
  public static String getFieldparamCode() {
    return FIELD_PARAMCODE;
  }

  private final static String FIELD_PARAMVALUE="paramValue";
  public static String getFieldparamValue() {
    return FIELD_PARAMVALUE;
  }

  private final static String FIELD_ISEDITED="isEdited";
  public static String getFieldisEdited() {
    return FIELD_ISEDITED;
  }

  private final static String FIELD_REMARK="remark";
  public static String getFieldremark() {
    return FIELD_REMARK;
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
    if(!(o instanceof System_param)) return false;
    System_param system_param= (System_param)o;
    return paramID!= null && paramID.equals(system_param.paramID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
