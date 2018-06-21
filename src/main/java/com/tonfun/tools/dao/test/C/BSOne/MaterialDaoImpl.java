package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Material;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialDao;



@Repository
public class MaterialDaoImpl extends BSOneGenericDao<Material, Long> implements IMaterialDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialDaoImpl.class);
}
