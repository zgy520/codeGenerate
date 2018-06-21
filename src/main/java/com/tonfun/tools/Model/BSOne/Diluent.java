package com.tonfun.tools.Model.BSOne;
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
import javax.persistence.EntityListeners;





@Entity
@EntityListeners(AuditListener.class)
@Table(name="diluent")
//对应的表为:diluent
public class Diluent{
  private static final Logger LOGGER = LoggerFactory.getLogger(Diluent.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long diluentID;
  //varchar(20) 
  @NotNull
  private String diluentName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "diluent")
  @JsonIgnore
  private Set<Mechanicalimpuritiesrecord>  mechanicalimpuritiesrecords = new HashSet<>();

  //关系实体创建完毕


  public void setDiluentID(Long diluentID){
    this.diluentID = diluentID;
  }


  public Long getDiluentID(){
    return this.diluentID;
  }


  public void setDiluentName(String diluentName){
    this.diluentName = diluentName;
  }


  public String getDiluentName(){
    return this.diluentName;
  }
  public Set<Mechanicalimpuritiesrecord> getMechanicalimpuritiesrecord() {
    return this.mechanicalimpuritiesrecords;
  }

  public void setMechanicalimpuritiesrecord(Set<Mechanicalimpuritiesrecord> mechanicalimpuritiesrecords) {
    this.mechanicalimpuritiesrecords = mechanicalimpuritiesrecords;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("diluentID=%s,diluentName=%s",this.diluentID,this.diluentName);
  }
  private final static String FIELD_DILUENTID="diluentID";
  public static String getFielddiluentID() {
    return FIELD_DILUENTID;
  }

  private final static String FIELD_DILUENTNAME="diluentName";
  public static String getFielddiluentName() {
    return FIELD_DILUENTNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Diluent)) return false;
    Diluent diluent= (Diluent)o;
    return diluentID!= null && diluentID.equals(diluent.diluentID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
