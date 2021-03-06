package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Watersample;
import com.tonfun.tools.dao.test.I.BSOne.IWatersampleDao;



@Repository
public class WatersampleDaoImpl extends BSOneGenericDao<Watersample, Long> implements IWatersampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(WatersampleDaoImpl.class);
}
