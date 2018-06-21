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
@Table(name="map_rolemenubutton")
//对应的表为:map_rolemenubutton
public class Map_rolemenubutton{
  private static final Logger LOGGER = LoggerFactory.getLogger(Map_rolemenubutton.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "roleID")
  @JsonIgnore
  private Role  role;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "buttonID")
  @JsonIgnore
  private Button  button;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "menuID")
  @JsonIgnore
  private Menu  menu;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }
  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Button getButton() {
    return this.button;
  }

  public void setButton(Button button) {
    this.button = button;
  }

  public Menu getMenu() {
    return this.menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s",this.recordID);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Map_rolemenubutton)) return false;
    Map_rolemenubutton map_rolemenubutton= (Map_rolemenubutton)o;
    return recordID!= null && recordID.equals(map_rolemenubutton.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
