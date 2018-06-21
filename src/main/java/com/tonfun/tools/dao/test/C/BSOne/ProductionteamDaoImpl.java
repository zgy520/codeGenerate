package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Productionteam;
import com.tonfun.tools.dao.test.I.BSOne.IProductionteamDao;



@Repository
public class ProductionteamDaoImpl extends BSOneGenericDao<Productionteam, Long> implements IProductionteamDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionteamDaoImpl.class);
}
