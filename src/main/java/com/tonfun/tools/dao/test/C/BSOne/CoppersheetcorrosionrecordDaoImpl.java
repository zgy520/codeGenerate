package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Coppersheetcorrosionrecord;
import com.tonfun.tools.dao.test.I.BSOne.ICoppersheetcorrosionrecordDao;



@Repository
public class CoppersheetcorrosionrecordDaoImpl extends BSOneGenericDao<Coppersheetcorrosionrecord, Long> implements ICoppersheetcorrosionrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CoppersheetcorrosionrecordDaoImpl.class);
}
