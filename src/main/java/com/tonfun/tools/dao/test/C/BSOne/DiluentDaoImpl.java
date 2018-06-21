package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Diluent;
import com.tonfun.tools.dao.test.I.BSOne.IDiluentDao;



@Repository
public class DiluentDaoImpl extends BSOneGenericDao<Diluent, Long> implements IDiluentDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(DiluentDaoImpl.class);
}
