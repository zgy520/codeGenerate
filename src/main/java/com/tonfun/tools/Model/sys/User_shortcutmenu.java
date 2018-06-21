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
@Table(name="user_shortcutmenu")
//对应的表为:user_shortcutmenu
public class User_shortcutmenu{
  private static final Logger LOGGER = LoggerFactory.getLogger(User_shortcutmenu.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //int(11) 连接标签ID
  private int aHrefID;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userID")
  @JsonIgnore
  private User  user;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setAHrefID(int aHrefID){
    this.aHrefID = aHrefID;
  }


  public int getAHrefID(){
    return this.aHrefID;
  }
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,aHrefID=%s",this.recordID,this.aHrefID);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_AHREFID="aHrefID";
  public static String getFieldaHrefID() {
    return FIELD_AHREFID;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof User_shortcutmenu)) return false;
    User_shortcutmenu user_shortcutmenu= (User_shortcutmenu)o;
    return recordID!= null && recordID.equals(user_shortcutmenu.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
