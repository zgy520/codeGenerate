package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Inventory;
import com.tonfun.tools.dao.test.I.BSOne.IInventoryDao;



@Repository
public class InventoryDaoImpl extends BSOneGenericDao<Inventory, Long> implements IInventoryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(InventoryDaoImpl.class);
}
