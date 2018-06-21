package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodbrand;
import com.tonfun.tools.dao.test.I.BSOne.IProdbrandDao;



@Repository
public class ProdbrandDaoImpl extends BSOneGenericDao<Prodbrand, Long> implements IProdbrandDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdbrandDaoImpl.class);
}
