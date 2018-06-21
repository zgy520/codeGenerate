package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Demulsifyrecord;
import com.tonfun.tools.dao.test.I.BSOne.IDemulsifyrecordDao;



@Repository
public class DemulsifyrecordDaoImpl extends BSOneGenericDao<Demulsifyrecord, Long> implements IDemulsifyrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(DemulsifyrecordDaoImpl.class);
}
