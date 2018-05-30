package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Salesorder;
import com.tonfun.tools.dao.test.I.ISalesorderDao;



@Repository
public class SalesorderDaoImpl extends SystemGenericDao<Salesorder, Long> implements ISalesorderDao {

}
