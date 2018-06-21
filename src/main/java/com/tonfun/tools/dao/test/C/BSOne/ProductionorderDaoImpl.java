package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Productionorder;
import com.tonfun.tools.dao.test.I.BSOne.IProductionorderDao;



@Repository
public class ProductionorderDaoImpl extends BSOneGenericDao<Productionorder, Long> implements IProductionorderDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionorderDaoImpl.class);
}
