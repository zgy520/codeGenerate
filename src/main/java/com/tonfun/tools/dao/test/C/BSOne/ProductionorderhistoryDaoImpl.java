package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Productionorderhistory;
import com.tonfun.tools.dao.test.I.BSOne.IProductionorderhistoryDao;



@Repository
public class ProductionorderhistoryDaoImpl extends BSOneGenericDao<Productionorderhistory, Long> implements IProductionorderhistoryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionorderhistoryDaoImpl.class);
}
