package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Pourpointsample;
import com.tonfun.tools.dao.test.I.BSOne.IPourpointsampleDao;



@Repository
public class PourpointsampleDaoImpl extends BSOneGenericDao<Pourpointsample, Long> implements IPourpointsampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PourpointsampleDaoImpl.class);
}
