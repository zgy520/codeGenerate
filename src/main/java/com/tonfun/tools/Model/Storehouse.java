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
@Table(name="storehouse")
//对应的表为:storehouse
public class Storehouse{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long storehouseID;
  //varchar(50) 
  @NotNull
  private String storehouseName;
  //varchar(50) 
  private String address;
  //varchar(15) 
  private String phoneNumber;
  //以下是对应的实体关系
  @OneToMany(mappedBy = "storehouse")
  private Set<Proddeliveryorder>  proddeliveryorders = new HashSet<>();

  @OneToMany(mappedBy = "storehouse")
  private Set<Prodgodownentry>  prodgodownentrys = new HashSet<>();

  @OneToMany(mappedBy = "storehouse")
  private Set<Godownkeeper>  godownkeepers = new HashSet<>();

  @OneToMany(mappedBy = "storehouse")
  private Set<Inventorylog>  inventorylogs = new HashSet<>();

  @OneToMany(mappedBy = "storehouse")
  private Set<Inventory>  inventorys = new HashSet<>();

  //关系实体创建完毕


  public void setStorehouseID(Long storehouseID){
    this.storehouseID = storehouseID;
  }


  public Long getStorehouseID(){
    return this.storehouseID;
  }


  public void setStorehouseName(String storehouseName){
    this.storehouseName = storehouseName;
  }


  public String getStorehouseName(){
    return this.storehouseName;
  }


  public void setAddress(String address){
    this.address = address;
  }


  public String getAddress(){
    return this.address;
  }


  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }


  public String getPhoneNumber(){
    return this.phoneNumber;
  }
  public Set<Proddeliveryorder> getProddeliveryorder() {
    return this.proddeliveryorders;
  }

  public void setProddeliveryorder(Set<Proddeliveryorder> proddeliveryorders) {
    this.proddeliveryorders = proddeliveryorders;
  }

  public Set<Prodgodownentry> getProdgodownentry() {
    return this.prodgodownentrys;
  }

  public void setProdgodownentry(Set<Prodgodownentry> prodgodownentrys) {
    this.prodgodownentrys = prodgodownentrys;
  }

  public Set<Godownkeeper> getGodownkeeper() {
    return this.godownkeepers;
  }

  public void setGodownkeeper(Set<Godownkeeper> godownkeepers) {
    this.godownkeepers = godownkeepers;
  }

  public Set<Inventorylog> getInventorylog() {
    return this.inventorylogs;
  }

  public void setInventorylog(Set<Inventorylog> inventorylogs) {
    this.inventorylogs = inventorylogs;
  }

  public Set<Inventory> getInventory() {
    return this.inventorys;
  }

  public void setInventory(Set<Inventory> inventorys) {
    this.inventorys = inventorys;
  }

  @Override
  public String toString() {
    return String.format("storehouseID=%s,storehouseName=%s,address=%s,phoneNumber=%s",this.storehouseID,this.storehouseName,this.address,this.phoneNumber);
  }
  private final static String FIELD_STOREHOUSEID="storehouseID";
  public static String getFieldstorehouseID() {
    return FIELD_STOREHOUSEID;
  }

  private final static String FIELD_STOREHOUSENAME="storehouseName";
  public static String getFieldstorehouseName() {
    return FIELD_STOREHOUSENAME;
  }

  private final static String FIELD_ADDRESS="address";
  public static String getFieldaddress() {
    return FIELD_ADDRESS;
  }

  private final static String FIELD_PHONENUMBER="phoneNumber";
  public static String getFieldphoneNumber() {
    return FIELD_PHONENUMBER;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Storehouse)) return false;
    Storehouse storehouse= (Storehouse)o;
    return storehouseID!= null && storehouseID.equals(storehouse.storehouseID);
  }
  @Override
  public int hashCode() {
    return 31;
  }
}
