package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Inventory;
import com.tonfun.tools.dao.test.I.IInventoryDao;



@Repository
public class InventoryDaoImpl extends SystemGenericDao<Inventory, Long> implements IInventoryDao {

}
