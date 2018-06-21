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
@Table(name="prodgodownentrydetail")
//对应的表为:prodgodownentrydetail
public class Prodgodownentrydetail{
  private static final Logger LOGGER = LoggerFactory.getLogger(Prodgodownentrydetail.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //int(11) 
  @NotNull
  private int amount;
  //varchar(100) 
  private String remark;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodGodownEntryID")
  @JsonIgnore
  private Prodgodownentry  prodgodownentry;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "prodID")
  @JsonIgnore
  private Product  product;

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setAmount(int amount){
    this.amount = amount;
  }


  public int getAmount(){
    return this.amount;
  }


  public void setRemark(String remark){
    this.remark = remark;
  }


  public String getRemark(){
    return this.remark;
  }
  public Prodgodownentry getProdgodownentry() {
    return this.prodgodownentry;
  }

  public void setProdgodownentry(Prodgodownentry prodgodownentry) {
    this.prodgodownentry = prodgodownentry;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,amount=%s,remark=%s",this.recordID,this.amount,this.remark);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_AMOUNT="amount";
  public static String getFieldamount() {
    return FIELD_AMOUNT;
  }

  private final static String FIELD_REMARK="remark";
  public static String getFieldremark() {
    return FIELD_REMARK;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Prodgodownentrydetail)) return false;
    Prodgodownentrydetail prodgodownentrydetail= (Prodgodownentrydetail)o;
    return recordID!= null && recordID.equals(prodgodownentrydetail.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
