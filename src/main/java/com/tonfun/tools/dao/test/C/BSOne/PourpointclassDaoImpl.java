package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Pourpointclass;
import com.tonfun.tools.dao.test.I.BSOne.IPourpointclassDao;



@Repository
public class PourpointclassDaoImpl extends BSOneGenericDao<Pourpointclass, Long> implements IPourpointclassDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PourpointclassDaoImpl.class);
}
