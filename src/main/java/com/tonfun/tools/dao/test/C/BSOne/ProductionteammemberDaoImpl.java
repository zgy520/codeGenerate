package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Productionteammember;
import com.tonfun.tools.dao.test.I.BSOne.IProductionteammemberDao;



@Repository
public class ProductionteammemberDaoImpl extends BSOneGenericDao<Productionteammember, Long> implements IProductionteammemberDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionteammemberDaoImpl.class);
}
