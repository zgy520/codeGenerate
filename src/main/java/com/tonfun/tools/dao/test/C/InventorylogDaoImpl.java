package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Inventorylog;
import com.tonfun.tools.dao.test.I.IInventorylogDao;



@Repository
public class InventorylogDaoImpl extends SystemGenericDao<Inventorylog, Long> implements IInventorylogDao {

}
