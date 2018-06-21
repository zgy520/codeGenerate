package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Materialbrand;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialbrandDao;



@Repository
public class MaterialbrandDaoImpl extends BSOneGenericDao<Materialbrand, Long> implements IMaterialbrandDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialbrandDaoImpl.class);
}
