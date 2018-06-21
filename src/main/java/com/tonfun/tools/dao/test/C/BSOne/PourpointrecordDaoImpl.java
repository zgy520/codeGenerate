package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Pourpointrecord;
import com.tonfun.tools.dao.test.I.BSOne.IPourpointrecordDao;



@Repository
public class PourpointrecordDaoImpl extends BSOneGenericDao<Pourpointrecord, Long> implements IPourpointrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PourpointrecordDaoImpl.class);
}
