package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Alkalivaluerecord;
import com.tonfun.tools.dao.test.I.BSOne.IAlkalivaluerecordDao;



@Repository
public class AlkalivaluerecordDaoImpl extends BSOneGenericDao<Alkalivaluerecord, Long> implements IAlkalivaluerecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(AlkalivaluerecordDaoImpl.class);
}
