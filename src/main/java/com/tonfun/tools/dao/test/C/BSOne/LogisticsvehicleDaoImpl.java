package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Logisticsvehicle;
import com.tonfun.tools.dao.test.I.BSOne.ILogisticsvehicleDao;



@Repository
public class LogisticsvehicleDaoImpl extends BSOneGenericDao<Logisticsvehicle, Long> implements ILogisticsvehicleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsvehicleDaoImpl.class);
}
