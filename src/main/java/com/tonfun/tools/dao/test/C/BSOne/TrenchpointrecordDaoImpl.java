package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Trenchpointrecord;
import com.tonfun.tools.dao.test.I.BSOne.ITrenchpointrecordDao;



@Repository
public class TrenchpointrecordDaoImpl extends BSOneGenericDao<Trenchpointrecord, Long> implements ITrenchpointrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(TrenchpointrecordDaoImpl.class);
}
