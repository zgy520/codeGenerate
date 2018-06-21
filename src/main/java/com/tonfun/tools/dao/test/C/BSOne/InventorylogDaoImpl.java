package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Inventorylog;
import com.tonfun.tools.dao.test.I.BSOne.IInventorylogDao;



@Repository
public class InventorylogDaoImpl extends BSOneGenericDao<Inventorylog, Long> implements IInventorylogDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(InventorylogDaoImpl.class);
}
