package com.tonfun.tools.Model;


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





@Entity
@Table(name="teamclass")
//对应的表为:teamclass
public class Teamclass{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long classID;
  //varchar(50) 
  @NotNull
  private String className;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "teamclass")
  private Set<Employee>  employees = new HashSet<>();

  //关系实体创建完毕


  public void setClassID(Long classID){
    this.classID = classID;
  }


  public Long getClassID(){
    return this.classID;
  }


  public void setClassName(String className){
    this.className = className;
  }


  public String getClassName(){
    return this.className;
  }
  public Set<Employee> getEmployee() {
    return this.employees;
  }

  public void setEmployee(Set<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return String.format("classID=%s,className=%s",this.classID,this.className);
  }
  private final static String FIELD_CLASSID="classID";
  public static String getFieldclassID() {
    return FIELD_CLASSID;
  }

  private final static String FIELD_CLASSNAME="className";
  public static String getFieldclassName() {
    return FIELD_CLASSNAME;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Teamclass)) return false;
    Teamclass teamclass= (Teamclass)o;
    return classID!= null && classID.equals(teamclass.classID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
