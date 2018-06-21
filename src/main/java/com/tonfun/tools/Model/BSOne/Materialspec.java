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
@Table(name="materialspec")
//对应的表为:materialspec
public class Materialspec{
  private static final Logger LOGGER = LoggerFactory.getLogger(Materialspec.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long specID;
  //varchar(50) 
  @NotNull
  private String specName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "materialspec")
  @JsonIgnore
  private Set<Material>  materials = new HashSet<>();

  //关系实体创建完毕


  public void setSpecID(Long specID){
    this.specID = specID;
  }


  public Long getSpecID(){
    return this.specID;
  }


  public void setSpecName(String specName){
    this.specName = specName;
  }


  public String getSpecName(){
    return this.specName;
  }
  public Set<Material> getMaterial() {
    return this.materials;
  }

  public void setMaterial(Set<Material> materials) {
    this.materials = materials;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("specID=%s,specName=%s",this.specID,this.specName);
  }
  private final static String FIELD_SPECID="specID";
  public static String getFieldspecID() {
    return FIELD_SPECID;
  }

  private final static String FIELD_SPECNAME="specName";
  public static String getFieldspecName() {
    return FIELD_SPECNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Materialspec)) return false;
    Materialspec materialspec= (Materialspec)o;
    return specID!= null && specID.equals(materialspec.specID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
