package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Productionorderhistory;
import com.tonfun.tools.dao.test.I.IProductionorderhistoryDao;



@Repository
public class ProductionorderhistoryDaoImpl extends SystemGenericDao<Productionorderhistory, Long> implements IProductionorderhistoryDao {

}
