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
@Table(name="button")
//对应的表为:button
public class Button{
  private static final Logger LOGGER = LoggerFactory.getLogger(Button.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long buttonID;
  //char(50) 按钮编码
  @NotNull
  private String buttonCode;
  //varchar(50) 按钮名称
  @NotNull
  private String buttonName;
  //varchar(50) 图标类名
  private String iconClass;
  //varchar(50) 图标名称
  private String iconName;
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
  @OneToMany(mappedBy = "button")
  @JsonIgnore
  private Set<Map_rolemenubutton>  map_rolemenubuttons = new HashSet<>();

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_menubutton",joinColumns = {@JoinColumn(name="buttonID")},inverseJoinColumns = {@JoinColumn(name="menuID")})
  @JsonIgnore
  private Set<Menu> map_menubutton_menus;
  //关系实体创建完毕


  public void setButtonID(Long buttonID){
    this.buttonID = buttonID;
  }


  public Long getButtonID(){
    return this.buttonID;
  }


  public void setButtonCode(String buttonCode){
    this.buttonCode = buttonCode;
  }


  public String getButtonCode(){
    return this.buttonCode;
  }


  public void setButtonName(String buttonName){
    this.buttonName = buttonName;
  }


  public String getButtonName(){
    return this.buttonName;
  }


  public void setIconClass(String iconClass){
    this.iconClass = iconClass;
  }


  public String getIconClass(){
    return this.iconClass;
  }


  public void setIconName(String iconName){
    this.iconName = iconName;
  }


  public String getIconName(){
    return this.iconName;
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
  public Set<Map_rolemenubutton> getMap_rolemenubutton() {
    return this.map_rolemenubuttons;
  }

  public void setMap_rolemenubutton(Set<Map_rolemenubutton> map_rolemenubuttons) {
    this.map_rolemenubuttons = map_rolemenubuttons;
  }

  public Set<Menu> getmap_menubutton_Menus() {
    return this.map_menubutton_menus;
  }

  public void setmap_menubutton_Menus(Set<Menu> map_menubutton_menus) {
    this.map_menubutton_menus = map_menubutton_menus;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("buttonID=%s,buttonCode=%s,buttonName=%s,iconClass=%s,iconName=%s,serial=%s,description=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.buttonID,this.buttonCode,this.buttonName,this.iconClass,this.iconName,this.serial,this.description,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_BUTTONID="buttonID";
  public static String getFieldbuttonID() {
    return FIELD_BUTTONID;
  }

  private final static String FIELD_BUTTONCODE="buttonCode";
  public static String getFieldbuttonCode() {
    return FIELD_BUTTONCODE;
  }

  private final static String FIELD_BUTTONNAME="buttonName";
  public static String getFieldbuttonName() {
    return FIELD_BUTTONNAME;
  }

  private final static String FIELD_ICONCLASS="iconClass";
  public static String getFieldiconClass() {
    return FIELD_ICONCLASS;
  }

  private final static String FIELD_ICONNAME="iconName";
  public static String getFieldiconName() {
    return FIELD_ICONNAME;
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
    if(!(o instanceof Button)) return false;
    Button button= (Button)o;
    return buttonID!= null && buttonID.equals(button.buttonID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
