package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Productionteam;
import com.tonfun.tools.dao.test.I.IProductionteamDao;



@Repository
public class ProductionteamDaoImpl extends SystemGenericDao<Productionteam, Long> implements IProductionteamDao {

}
