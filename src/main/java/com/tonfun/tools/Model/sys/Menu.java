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
@Table(name="menu")
//对应的表为:menu
public class Menu{
  private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long menuID;
  //char(50) 菜单编码
  @NotNull
  private String menuCode;
  //varchar(50) 菜单名称
  @NotNull
  private String menuName;
  //bigint(20) 序号
  private Long serial;
  //varchar(200) URL
  private String url;
  //varchar(50) 图标类名
  private String iconClass;
  //varchar(50) 图标名称
  private String iconName;
  //varchar(200) 描述
  private String description;
  //tinyint(1) 可见状态
  private int visibleState;
  //tinyint(1) 启用状态
  private int enabledState;
  //varchar(50) 创建者
  private String creator;
  //datetime 创建时间
  private LocalDateTime createTime;
  //varchar(50) 更新者
  private String updator;
  //datetime 更新时间
  private LocalDateTime updateTime;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "menu")
  @JsonIgnore
  private Set<Map_rolemenubutton>  map_rolemenubuttons = new HashSet<>();

  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_rolemenucol",joinColumns = {@JoinColumn(name="menuID")},inverseJoinColumns = {@JoinColumn(name="roleID")})
  @JsonIgnore
  private Set<Role> map_rolemenucol_roles;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_rolemenu",joinColumns = {@JoinColumn(name="menuID")},inverseJoinColumns = {@JoinColumn(name="roleID")})
  @JsonIgnore
  private Set<Role> map_rolemenu_roles;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="map_menubutton",joinColumns = {@JoinColumn(name="menuID")},inverseJoinColumns = {@JoinColumn(name="buttonID")})
  @JsonIgnore
  private Set<Button> map_menubutton_buttons;
  //关系实体创建完毕


  public void setMenuID(Long menuID){
    this.menuID = menuID;
  }


  public Long getMenuID(){
    return this.menuID;
  }


  public void setMenuCode(String menuCode){
    this.menuCode = menuCode;
  }


  public String getMenuCode(){
    return this.menuCode;
  }


  public void setMenuName(String menuName){
    this.menuName = menuName;
  }


  public String getMenuName(){
    return this.menuName;
  }


  public void setSerial(Long serial){
    this.serial = serial;
  }


  public Long getSerial(){
    return this.serial;
  }


  public void setUrl(String url){
    this.url = url;
  }


  public String getUrl(){
    return this.url;
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


  public void setDescription(String description){
    this.description = description;
  }


  public String getDescription(){
    return this.description;
  }


  public void setVisibleState(int visibleState){
    this.visibleState = visibleState;
  }


  public int getVisibleState(){
    return this.visibleState;
  }


  public void setEnabledState(int enabledState){
    this.enabledState = enabledState;
  }


  public int getEnabledState(){
    return this.enabledState;
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

  public Set<Role> getmap_rolemenucol_Roles() {
    return this.map_rolemenucol_roles;
  }

  public void setmap_rolemenucol_Roles(Set<Role> map_rolemenucol_roles) {
    this.map_rolemenucol_roles = map_rolemenucol_roles;
  }

  public Set<Role> getmap_rolemenu_Roles() {
    return this.map_rolemenu_roles;
  }

  public void setmap_rolemenu_Roles(Set<Role> map_rolemenu_roles) {
    this.map_rolemenu_roles = map_rolemenu_roles;
  }

  public Set<Button> getmap_menubutton_Buttons() {
    return this.map_menubutton_buttons;
  }

  public void setmap_menubutton_Buttons(Set<Button> map_menubutton_buttons) {
    this.map_menubutton_buttons = map_menubutton_buttons;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("menuID=%s,menuCode=%s,menuName=%s,serial=%s,url=%s,iconClass=%s,iconName=%s,description=%s,visibleState=%s,enabledState=%s,creator=%s,createTime=%s,updator=%s,updateTime=%s",this.menuID,this.menuCode,this.menuName,this.serial,this.url,this.iconClass,this.iconName,this.description,this.visibleState,this.enabledState,this.creator,this.createTime,this.updator,this.updateTime);
  }
  private final static String FIELD_MENUID="menuID";
  public static String getFieldmenuID() {
    return FIELD_MENUID;
  }

  private final static String FIELD_MENUCODE="menuCode";
  public static String getFieldmenuCode() {
    return FIELD_MENUCODE;
  }

  private final static String FIELD_MENUNAME="menuName";
  public static String getFieldmenuName() {
    return FIELD_MENUNAME;
  }

  private final static String FIELD_SERIAL="serial";
  public static String getFieldserial() {
    return FIELD_SERIAL;
  }

  private final static String FIELD_URL="url";
  public static String getFieldurl() {
    return FIELD_URL;
  }

  private final static String FIELD_ICONCLASS="iconClass";
  public static String getFieldiconClass() {
    return FIELD_ICONCLASS;
  }

  private final static String FIELD_ICONNAME="iconName";
  public static String getFieldiconName() {
    return FIELD_ICONNAME;
  }

  private final static String FIELD_DESCRIPTION="description";
  public static String getFielddescription() {
    return FIELD_DESCRIPTION;
  }

  private final static String FIELD_VISIBLESTATE="visibleState";
  public static String getFieldvisibleState() {
    return FIELD_VISIBLESTATE;
  }

  private final static String FIELD_ENABLEDSTATE="enabledState";
  public static String getFieldenabledState() {
    return FIELD_ENABLEDSTATE;
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
    if(!(o instanceof Menu)) return false;
    Menu menu= (Menu)o;
    return menuID!= null && menuID.equals(menu.menuID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
