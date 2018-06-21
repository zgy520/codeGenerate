package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Materialspec;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialspecDao;



@Repository
public class MaterialspecDaoImpl extends BSOneGenericDao<Materialspec, Long> implements IMaterialspecDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialspecDaoImpl.class);
}
