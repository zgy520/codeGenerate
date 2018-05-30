package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Logisticsvehicle;
import com.tonfun.tools.dao.test.I.ILogisticsvehicleDao;



@Repository
public class LogisticsvehicleDaoImpl extends SystemGenericDao<Logisticsvehicle, Long> implements ILogisticsvehicleDao {

}
