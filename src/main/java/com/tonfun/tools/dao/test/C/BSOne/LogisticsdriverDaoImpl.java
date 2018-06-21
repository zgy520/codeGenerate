package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Logisticsdriver;
import com.tonfun.tools.dao.test.I.BSOne.ILogisticsdriverDao;



@Repository
public class LogisticsdriverDaoImpl extends BSOneGenericDao<Logisticsdriver, Long> implements ILogisticsdriverDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsdriverDaoImpl.class);
}
