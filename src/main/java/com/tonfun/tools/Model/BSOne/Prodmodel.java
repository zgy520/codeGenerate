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
@Table(name="prodmodel")
//对应的表为:prodmodel
public class Prodmodel{
  private static final Logger LOGGER = LoggerFactory.getLogger(Prodmodel.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long modelID;
  //varchar(50) 
  @NotNull
  private String modelName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "prodmodel")
  @JsonIgnore
  private Set<Product>  products = new HashSet<>();

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
  public Set<Product> getProduct() {
    return this.products;
  }

  public void setProduct(Set<Product> products) {
    this.products = products;
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
    if(!(o instanceof Prodmodel)) return false;
    Prodmodel prodmodel= (Prodmodel)o;
    return modelID!= null && modelID.equals(prodmodel.modelID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
