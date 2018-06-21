package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Storehouse;
import com.tonfun.tools.dao.test.I.BSOne.IStorehouseDao;



@Repository
public class StorehouseDaoImpl extends BSOneGenericDao<Storehouse, Long> implements IStorehouseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorehouseDaoImpl.class);
}
