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
@Table(name="employee")
//对应的表为:employee
public class Employee{
  private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long employeeID;
  //varchar(50) 
  @NotNull
  private String employeeName;
  //varchar(15) 
  @NotNull
  private String phoneNumber;
  //bigint(20) 
  @NotNull
  private Long orgID;
  //bigint(20) 
  private Long userID;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classID")
  @JsonIgnore
  private Teamclass  teamclass;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "posID")
  @JsonIgnore
  private Position  position;

  @OneToMany(mappedBy = "employee")
  @JsonIgnore
  private Set<Godownkeeper>  godownkeepers = new HashSet<>();

  @OneToMany(mappedBy = "employee")
  @JsonIgnore
  private Set<Manager>  managers = new HashSet<>();

  //关系实体创建完毕


  public void setEmployeeID(Long employeeID){
    this.employeeID = employeeID;
  }


  public Long getEmployeeID(){
    return this.employeeID;
  }


  public void setEmployeeName(String employeeName){
    this.employeeName = employeeName;
  }


  public String getEmployeeName(){
    return this.employeeName;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }


  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }


  public Long getOrgID(){
    return this.orgID;
  }


  public void setUserID(Long userID){
    this.userID = userID;
  }


  public Long getUserID(){
    return this.userID;
  }
  public Teamclass getTeamclass() {
    return this.teamclass;
  }

  public void setTeamclass(Teamclass teamclass) {
    this.teamclass = teamclass;
  }

  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Set<Godownkeeper> getGodownkeeper() {
    return this.godownkeepers;
  }

  public void setGodownkeeper(Set<Godownkeeper> godownkeepers) {
    this.godownkeepers = godownkeepers;
  }

  public Set<Manager> getManager() {
    return this.managers;
  }

  public void setManager(Set<Manager> managers) {
    this.managers = managers;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("employeeID=%s,employeeName=%s,phoneNumber=%s,orgID=%s,userID=%s",this.employeeID,this.employeeName,this.phoneNumber,this.orgID,this.userID);
  }
  private final static String FIELD_EMPLOYEEID="employeeID";
  public static String getFieldemployeeID() {
    return FIELD_EMPLOYEEID;
  }

  private final static String FIELD_EMPLOYEENAME="employeeName";
  public static String getFieldemployeeName() {
    return FIELD_EMPLOYEENAME;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  private final static String FIELD_ORGID="orgID";
  public static String getFieldorgID() {
    return FIELD_ORGID;
  }

  private final static String FIELD_USERID="userID";
  public static String getFielduserID() {
    return FIELD_USERID;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Employee)) return false;
    Employee employee= (Employee)o;
    return employeeID!= null && employeeID.equals(employee.employeeID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
