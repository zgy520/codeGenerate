package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Log;
import com.tonfun.tools.dao.test.I.sys.ILogDao;



@Repository
public class LogDaoImpl extends SystemGenericDao<Log, Long> implements ILogDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogDaoImpl.class);
}
