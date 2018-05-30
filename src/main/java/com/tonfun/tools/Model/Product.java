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
@Table(name="product")
//对应的表为:product
public class Product{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long prodID;
  //varchar(50) 
  @NotNull
  private String prodName;
  //varchar(50) 
  private String specifications;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "specID")
  private Prodspec  prodspec;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "unitID")
  private Produnit  produnit;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "modelID")
  private Prodmodel  prodmodel;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brandID")
  private Prodbrand  prodbrand;

  @OneToMany(mappedBy = "product")
  private Set<Salesorderdetail>  salesorderdetails = new HashSet<>();

  @OneToMany(mappedBy = "product")
  private Set<Productionorder>  productionorders = new HashSet<>();

  @OneToMany(mappedBy = "product")
  private Set<Proddeliveryorderdetail>  proddeliveryorderdetails = new HashSet<>();

  @OneToMany(mappedBy = "product")
  private Set<Inventory>  inventorys = new HashSet<>();

  @OneToMany(mappedBy = "product")
  private Set<Prodgodownentrydetail>  prodgodownentrydetails = new HashSet<>();

  @OneToMany(mappedBy = "product")
  private Set<Inventorylog>  inventorylogs = new HashSet<>();

  //关系实体创建完毕


  public void setProdID(Long prodID){
    this.prodID = prodID;
  }


  public Long getProdID(){
    return this.prodID;
  }


  public void setProdName(String prodName){
    this.prodName = prodName;
  }


  public String getProdName(){
    return this.prodName;
  }


  public void setSpecifications(String specifications){
    this.specifications = specifications;
  }


  public String getSpecifications(){
    return this.specifications;
  }
  public Prodspec getProdspec() {
    return this.prodspec;
  }

  public void setProdspec(Prodspec prodspec) {
    this.prodspec = prodspec;
  }

  public Produnit getProdunit() {
    return this.produnit;
  }

  public void setProdunit(Produnit produnit) {
    this.produnit = produnit;
  }

  public Prodmodel getProdmodel() {
    return this.prodmodel;
  }

  public void setProdmodel(Prodmodel prodmodel) {
    this.prodmodel = prodmodel;
  }

  public Prodbrand getProdbrand() {
    return this.prodbrand;
  }

  public void setProdbrand(Prodbrand prodbrand) {
    this.prodbrand = prodbrand;
  }

  public Set<Salesorderdetail> getSalesorderdetail() {
    return this.salesorderdetails;
  }

  public void setSalesorderdetail(Set<Salesorderdetail> salesorderdetails) {
    this.salesorderdetails = salesorderdetails;
  }

  public Set<Productionorder> getProductionorder() {
    return this.productionorders;
  }

  public void setProductionorder(Set<Productionorder> productionorders) {
    this.productionorders = productionorders;
  }

  public Set<Proddeliveryorderdetail> getProddeliveryorderdetail() {
    return this.proddeliveryorderdetails;
  }

  public void setProddeliveryorderdetail(Set<Proddeliveryorderdetail> proddeliveryorderdetails) {
    this.proddeliveryorderdetails = proddeliveryorderdetails;
  }

  public Set<Inventory> getInventory() {
    return this.inventorys;
  }

  public void setInventory(Set<Inventory> inventorys) {
    this.inventorys = inventorys;
  }

  public Set<Prodgodownentrydetail> getProdgodownentrydetail() {
    return this.prodgodownentrydetails;
  }

  public void setProdgodownentrydetail(Set<Prodgodownentrydetail> prodgodownentrydetails) {
    this.prodgodownentrydetails = prodgodownentrydetails;
  }

  public Set<Inventorylog> getInventorylog() {
    return this.inventorylogs;
  }

  public void setInventorylog(Set<Inventorylog> inventorylogs) {
    this.inventorylogs = inventorylogs;
  }

  @Override
  public String toString() {
    return String.format("prodID=%s,prodName=%s,specifications=%s",this.prodID,this.prodName,this.specifications);
  }
  private final static String FIELD_PRODID="prodID";
  public static String getFieldprodID() {
    return FIELD_PRODID;
  }

  private final static String FIELD_PRODNAME="prodName";
  public static String getFieldprodName() {
    return FIELD_PRODNAME;
  }

  private final static String FIELD_SPECIFICATIONS="specifications";
  public static String getFieldspecifications() {
    return FIELD_SPECIFICATIONS;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Product)) return false;
    Product product= (Product)o;
    return prodID!= null && prodID.equals(product.prodID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
