package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Materialmodel;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialmodelDao;



@Repository
public class MaterialmodelDaoImpl extends BSOneGenericDao<Materialmodel, Long> implements IMaterialmodelDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialmodelDaoImpl.class);
}
