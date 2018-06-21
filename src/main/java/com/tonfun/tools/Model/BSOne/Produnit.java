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
@Table(name="produnit")
//对应的表为:produnit
public class Produnit{
  private static final Logger LOGGER = LoggerFactory.getLogger(Produnit.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long unitID;
  //varchar(50) 
  @NotNull
  private String unitName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "produnit")
  @JsonIgnore
  private Set<Product>  products = new HashSet<>();

  //关系实体创建完毕


  public void setUnitID(Long unitID){
    this.unitID = unitID;
  }


  public Long getUnitID(){
    return this.unitID;
  }


  public void setUnitName(String unitName){
    this.unitName = unitName;
  }


  public String getUnitName(){
    return this.unitName;
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
    return String.format("unitID=%s,unitName=%s",this.unitID,this.unitName);
  }
  private final static String FIELD_UNITID="unitID";
  public static String getFieldunitID() {
    return FIELD_UNITID;
  }

  private final static String FIELD_UNITNAME="unitName";
  public static String getFieldunitName() {
    return FIELD_UNITNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Produnit)) return false;
    Produnit produnit= (Produnit)o;
    return unitID!= null && unitID.equals(produnit.unitID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
