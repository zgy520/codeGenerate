package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Inspectionclass;
import com.tonfun.tools.dao.test.I.BSOne.IInspectionclassDao;



@Repository
public class InspectionclassDaoImpl extends BSOneGenericDao<Inspectionclass, Long> implements IInspectionclassDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(InspectionclassDaoImpl.class);
}
