package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Salesorderhistory;
import com.tonfun.tools.dao.test.I.ISalesorderhistoryDao;



@Repository
public class SalesorderhistoryDaoImpl extends SystemGenericDao<Salesorderhistory, Long> implements ISalesorderhistoryDao {

}
