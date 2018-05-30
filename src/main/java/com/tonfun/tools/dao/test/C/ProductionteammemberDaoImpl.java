package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Productionteammember;
import com.tonfun.tools.dao.test.I.IProductionteammemberDao;



@Repository
public class ProductionteammemberDaoImpl extends SystemGenericDao<Productionteammember, Long> implements IProductionteammemberDao {

}
