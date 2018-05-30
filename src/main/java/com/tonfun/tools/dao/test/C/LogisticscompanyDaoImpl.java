package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Logisticscompany;
import com.tonfun.tools.dao.test.I.ILogisticscompanyDao;



@Repository
public class LogisticscompanyDaoImpl extends SystemGenericDao<Logisticscompany, Long> implements ILogisticscompanyDao {

}
