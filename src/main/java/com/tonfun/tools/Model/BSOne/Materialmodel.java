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
@Table(name="materialmodel")
//对应的表为:materialmodel
public class Materialmodel{
  private static final Logger LOGGER = LoggerFactory.getLogger(Materialmodel.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long modelID;
  //varchar(50) 
  @NotNull
  private String modelName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "materialmodel")
  @JsonIgnore
  private Set<Material>  materials = new HashSet<>();

  //关系实体创建完毕


  public void setModelID(Long modelID){
    this.modelID = modelID;
  }


  public Long getModelID(){
    return this.modelID;
  }


  public void setModelName(String modelName){
    this.modelName = modelName;
  }


  public String getModelName(){
    return this.modelName;
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
    return String.format("modelID=%s,modelName=%s",this.modelID,this.modelName);
  }
  private final static String FIELD_MODELID="modelID";
  public static String getFieldmodelID() {
    return FIELD_MODELID;
  }

  private final static String FIELD_MODELNAME="modelName";
  public static String getFieldmodelName() {
    return FIELD_MODELNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Materialmodel)) return false;
    Materialmodel materialmodel= (Materialmodel)o;
    return modelID!= null && modelID.equals(materialmodel.modelID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
