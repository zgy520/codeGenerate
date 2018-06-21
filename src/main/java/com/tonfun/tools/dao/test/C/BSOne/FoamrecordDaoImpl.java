package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Foamrecord;
import com.tonfun.tools.dao.test.I.BSOne.IFoamrecordDao;



@Repository
public class FoamrecordDaoImpl extends BSOneGenericDao<Foamrecord, Long> implements IFoamrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(FoamrecordDaoImpl.class);
}
