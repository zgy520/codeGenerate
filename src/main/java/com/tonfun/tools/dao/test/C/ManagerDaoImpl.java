package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Manager;
import com.tonfun.tools.dao.test.I.IManagerDao;



@Repository
public class ManagerDaoImpl extends SystemGenericDao<Manager, Long> implements IManagerDao {

}
