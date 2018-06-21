package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Godownkeeper;
import com.tonfun.tools.dao.test.I.BSOne.IGodownkeeperDao;



@Repository
public class GodownkeeperDaoImpl extends BSOneGenericDao<Godownkeeper, Long> implements IGodownkeeperDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(GodownkeeperDaoImpl.class);
}
