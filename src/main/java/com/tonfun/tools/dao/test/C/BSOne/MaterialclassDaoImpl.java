package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Materialclass;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialclassDao;



@Repository
public class MaterialclassDaoImpl extends BSOneGenericDao<Materialclass, Long> implements IMaterialclassDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialclassDaoImpl.class);
}
