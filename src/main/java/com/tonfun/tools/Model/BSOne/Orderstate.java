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
@Table(name="orderstate")
//对应的表为:orderstate
public class Orderstate{
  private static final Logger LOGGER = LoggerFactory.getLogger(Orderstate.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long stateID;
  //varchar(50) 
  @NotNull
  private String stateName;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Prodgodownentry>  prodgodownentrys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Prodgodownentryhistory>  prodgodownentryhistorys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Salesorder>  salesorders = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Productionorder>  productionorders = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Productionorderhistory>  productionorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Proddeliveryorderhistory>  proddeliveryorderhistorys = new HashSet<>();

  @OneToMany(mappedBy = "orderstate")
  @JsonIgnore
  private Set<Proddeliveryorder>  proddeliveryorders = new HashSet<>();

  //关系实体创建完毕


  public void setStateID(Long stateID){
    this.stateID = stateID;
  }


  public Long getStateID(){
    return this.stateID;
  }


  public void setStateName(String stateName){
    this.stateName = stateName;
  }


  public String getStateName(){
    return this.stateName;
  }
  public Set<Prodgodownentry> getProdgodownentry() {
    return this.prodgodownentrys;
  }

  public void setProdgodownentry(Set<Prodgodownentry> prodgodownentrys) {
    this.prodgodownentrys = prodgodownentrys;
  }

  public Set<Prodgodownentryhistory> getProdgodownentryhistory() {
    return this.prodgodownentryhistorys;
  }

  public void setProdgodownentryhistory(Set<Prodgodownentryhistory> prodgodownentryhistorys) {
    this.prodgodownentryhistorys = prodgodownentryhistorys;
  }

  public Set<Salesorder> getSalesorder() {
    return this.salesorders;
  }

  public void setSalesorder(Set<Salesorder> salesorders) {
    this.salesorders = salesorders;
  }

  public Set<Productionorder> getProductionorder() {
    return this.productionorders;
  }

  public void setProductionorder(Set<Productionorder> productionorders) {
    this.productionorders = productionorders;
  }

  public Set<Productionorderhistory> getProductionorderhistory() {
    return this.productionorderhistorys;
  }

  public void setProductionorderhistory(Set<Productionorderhistory> productionorderhistorys) {
    this.productionorderhistorys = productionorderhistorys;
  }

  public Set<Proddeliveryorderhistory> getProddeliveryorderhistory() {
    return this.proddeliveryorderhistorys;
  }

  public void setProddeliveryorderhistory(Set<Proddeliveryorderhistory> proddeliveryorderhistorys) {
    this.proddeliveryorderhistorys = proddeliveryorderhistorys;
  }

  public Set<Proddeliveryorder> getProddeliveryorder() {
    return this.proddeliveryorders;
  }

  public void setProddeliveryorder(Set<Proddeliveryorder> proddeliveryorders) {
    this.proddeliveryorders = proddeliveryorders;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("stateID=%s,stateName=%s",this.stateID,this.stateName);
  }
  private final static String FIELD_STATEID="stateID";
  public static String getFieldstateID() {
    return FIELD_STATEID;
  }

  private final static String FIELD_STATENAME="stateName";
  public static String getFieldstateName() {
    return FIELD_STATENAME;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Orderstate)) return false;
    Orderstate orderstate= (Orderstate)o;
    return stateID!= null && stateID.equals(orderstate.stateID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
