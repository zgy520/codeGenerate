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
@Table(name="position")
//对应的表为:position
public class Position{
  private static final Logger LOGGER = LoggerFactory.getLogger(Position.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long posID;
  //varchar(50) 
  @NotNull
  private String posName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "position")
  @JsonIgnore
  private Set<Employee>  employees = new HashSet<>();

  //关系实体创建完毕


  public void setPosID(Long posID){
    this.posID = posID;
  }


  public Long getPosID(){
    return this.posID;
  }


  public void setPosName(String posName){
    this.posName = posName;
  }


  public String getPosName(){
    return this.posName;
  }
  public Set<Employee> getEmployee() {
    return this.employees;
  }

  public void setEmployee(Set<Employee> employees) {
    this.employees = employees;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("posID=%s,posName=%s",this.posID,this.posName);
  }
  private final static String FIELD_POSID="posID";
  public static String getFieldposID() {
    return FIELD_POSID;
  }

  private final static String FIELD_POSNAME="posName";
  public static String getFieldposName() {
    return FIELD_POSNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Position)) return false;
    Position position= (Position)o;
    return posID!= null && posID.equals(position.posID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
