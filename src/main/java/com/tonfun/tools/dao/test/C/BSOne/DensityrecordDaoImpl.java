package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Densityrecord;
import com.tonfun.tools.dao.test.I.BSOne.IDensityrecordDao;



@Repository
public class DensityrecordDaoImpl extends BSOneGenericDao<Densityrecord, Long> implements IDensityrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(DensityrecordDaoImpl.class);
}
