package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Manager;
import com.tonfun.tools.dao.test.I.BSOne.IManagerDao;



@Repository
public class ManagerDaoImpl extends BSOneGenericDao<Manager, Long> implements IManagerDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ManagerDaoImpl.class);
}
