package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Inspectionrecord;
import com.tonfun.tools.dao.test.I.BSOne.IInspectionrecordDao;



@Repository
public class InspectionrecordDaoImpl extends BSOneGenericDao<Inspectionrecord, Long> implements IInspectionrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(InspectionrecordDaoImpl.class);
}
