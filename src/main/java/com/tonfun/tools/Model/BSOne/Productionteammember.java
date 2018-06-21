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
@Table(name="productionteammember")
//对应的表为:productionteammember
public class Productionteammember{
  private static final Logger LOGGER = LoggerFactory.getLogger(Productionteammember.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long memberID;
  //varchar(50) 
  @NotNull
  private String posName;
  //varchar(50) 
  @NotNull
  private String employeeName;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "teamID")
  @JsonIgnore
  private Productionteam  productionteam;

  //关系实体创建完毕


  public void setMemberID(Long memberID){
    this.memberID = memberID;
  }


  public Long getMemberID(){
    return this.memberID;
  }


  public void setPosName(String posName){
    this.posName = posName;
  }


  public String getPosName(){
    return this.posName;
  }


  public void setEmployeeName(String employeeName){
    this.employeeName = employeeName;
  }


  public String getEmployeeName(){
    return this.employeeName;
  }
  public Productionteam getProductionteam() {
    return this.productionteam;
  }

  public void setProductionteam(Productionteam productionteam) {
    this.productionteam = productionteam;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("memberID=%s,posName=%s,employeeName=%s",this.memberID,this.posName,this.employeeName);
  }
  private final static String FIELD_MEMBERID="memberID";
  public static String getFieldmemberID() {
    return FIELD_MEMBERID;
  }

  private final static String FIELD_POSNAME="posName";
  public static String getFieldposName() {
    return FIELD_POSNAME;
  }

  private final static String FIELD_EMPLOYEENAME="employeeName";
  public static String getFieldemployeeName() {
    return FIELD_EMPLOYEENAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Productionteammember)) return false;
    Productionteammember productionteammember= (Productionteammember)o;
    return memberID!= null && memberID.equals(productionteammember.memberID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
