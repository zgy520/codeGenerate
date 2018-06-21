package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Alkalivaluesample;
import com.tonfun.tools.dao.test.I.BSOne.IAlkalivaluesampleDao;



@Repository
public class AlkalivaluesampleDaoImpl extends BSOneGenericDao<Alkalivaluesample, Long> implements IAlkalivaluesampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(AlkalivaluesampleDaoImpl.class);
}
