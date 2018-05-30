package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodgodownentryhistory;
import com.tonfun.tools.dao.test.I.IProdgodownentryhistoryDao;



@Repository
public class ProdgodownentryhistoryDaoImpl extends SystemGenericDao<Prodgodownentryhistory, Long> implements IProdgodownentryhistoryDao {

}
