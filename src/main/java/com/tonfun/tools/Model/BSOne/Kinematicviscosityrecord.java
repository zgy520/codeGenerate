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
@Table(name="kinematicviscosityrecord")
//对应的表为:kinematicviscosityrecord
public class Kinematicviscosityrecord{
  private static final Logger LOGGER = LoggerFactory.getLogger(Kinematicviscosityrecord.class);
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long recordID;
  //int(11) 
  @NotNull
  private int viscosityIndex;
  //以下是对应的实体关系
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "inspOrderID")
  @JsonIgnore
  private Inspectionrecord  inspectionrecord;

  @OneToMany(mappedBy = "kinematicviscosityrecord")
  @JsonIgnore
  private Set<Kinematicviscosityitemrecord>  kinematicviscosityitemrecords = new HashSet<>();

  //关系实体创建完毕


  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }


  public Long getRecordID(){
    return this.recordID;
  }


  public void setViscosityIndex(int viscosityIndex){
    this.viscosityIndex = viscosityIndex;
  }


  public int getViscosityIndex(){
    return this.viscosityIndex;
  }
  public Inspectionrecord getInspectionrecord() {
    return this.inspectionrecord;
  }

  public void setInspectionrecord(Inspectionrecord inspectionrecord) {
    this.inspectionrecord = inspectionrecord;
  }

  public Set<Kinematicviscosityitemrecord> getKinematicviscosityitemrecord() {
    return this.kinematicviscosityitemrecords;
  }

  public void setKinematicviscosityitemrecord(Set<Kinematicviscosityitemrecord> kinematicviscosityitemrecords) {
    this.kinematicviscosityitemrecords = kinematicviscosityitemrecords;
  }

  /**
  * 
  */
  @Override
  public String toString() {
    return String.format("recordID=%s,viscosityIndex=%s",this.recordID,this.viscosityIndex);
  }
  private final static String FIELD_RECORDID="recordID";
  public static String getFieldrecordID() {
    return FIELD_RECORDID;
  }

  private final static String FIELD_VISCOSITYINDEX="viscosityIndex";
  public static String getFieldviscosityIndex() {
    return FIELD_VISCOSITYINDEX;
  }

  /**
  * 
  */
  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Kinematicviscosityrecord)) return false;
    Kinematicviscosityrecord kinematicviscosityrecord= (Kinematicviscosityrecord)o;
    return recordID!= null && recordID.equals(kinematicviscosityrecord.recordID);
  }
  /**
  * 
  */
  @Override
  public int hashCode() {
    return 31;
  }
}
