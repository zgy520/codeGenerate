package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Waterrecord;
import com.tonfun.tools.dao.test.I.BSOne.IWaterrecordDao;



@Repository
public class WaterrecordDaoImpl extends BSOneGenericDao<Waterrecord, Long> implements IWaterrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(WaterrecordDaoImpl.class);
}
