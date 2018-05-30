package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Productionorder;
import com.tonfun.tools.dao.test.I.IProductionorderDao;



@Repository
public class ProductionorderDaoImpl extends SystemGenericDao<Productionorder, Long> implements IProductionorderDao {

}
