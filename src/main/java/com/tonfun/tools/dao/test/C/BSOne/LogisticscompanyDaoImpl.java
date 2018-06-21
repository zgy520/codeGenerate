package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Logisticscompany;
import com.tonfun.tools.dao.test.I.BSOne.ILogisticscompanyDao;



@Repository
public class LogisticscompanyDaoImpl extends BSOneGenericDao<Logisticscompany, Long> implements ILogisticscompanyDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogisticscompanyDaoImpl.class);
}
