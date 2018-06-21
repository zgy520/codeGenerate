package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.System_param;
import com.tonfun.tools.dao.test.I.sys.ISystem_paramDao;



@Repository
public class System_paramDaoImpl extends SystemGenericDao<System_param, Long> implements ISystem_paramDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(System_paramDaoImpl.class);
}
