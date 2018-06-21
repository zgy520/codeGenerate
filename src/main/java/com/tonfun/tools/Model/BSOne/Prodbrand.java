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
@Table(name="prodbrand")
//对应的表为:prodbrand
public class Prodbrand{
  private static final Logger LOGGER = LoggerFactory.getLogger(Prodbrand.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long brandID;
  //varchar(50) 
  @NotNull
  private String brandName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "prodbrand")
  @JsonIgnore
  private Set<Product>  products = new HashSet<>();

  //关系实体创建完毕


  public void setBrandID(Long brandID){
    this.brandID = brandID;
  }


  public Long getBrandID(){
    return this.brandID;
  }


  public void setBrandName(String brandName){
    this.brandName = brandName;
  }


  public String getBrandName(){
    return this.brandName;
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
    return String.format("brandID=%s,brandName=%s",this.brandID,this.brandName);
  }
  private final static String FIELD_BRANDID="brandID";
  public static String getFieldbrandID() {
    return FIELD_BRANDID;
  }

  private final static String FIELD_BRANDNAME="brandName";
  public static String getFieldbrandName() {
    return FIELD_BRANDNAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Prodbrand)) return false;
    Prodbrand prodbrand= (Prodbrand)o;
    return brandID!= null && brandID.equals(prodbrand.brandID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
