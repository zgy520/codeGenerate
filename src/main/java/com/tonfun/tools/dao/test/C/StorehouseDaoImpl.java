package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Storehouse;
import com.tonfun.tools.dao.test.I.IStorehouseDao;



@Repository
public class StorehouseDaoImpl extends SystemGenericDao<Storehouse, Long> implements IStorehouseDao {

}
