package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Logisticsdriver;
import com.tonfun.tools.dao.test.I.ILogisticsdriverDao;



@Repository
public class LogisticsdriverDaoImpl extends SystemGenericDao<Logisticsdriver, Long> implements ILogisticsdriverDao {

}
