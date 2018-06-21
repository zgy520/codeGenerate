package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Materialunit;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialunitDao;



@Repository
public class MaterialunitDaoImpl extends BSOneGenericDao<Materialunit, Long> implements IMaterialunitDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialunitDaoImpl.class);
}
