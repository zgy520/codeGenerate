package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodgodownentry;
import com.tonfun.tools.dao.test.I.IProdgodownentryDao;



@Repository
public class ProdgodownentryDaoImpl extends SystemGenericDao<Prodgodownentry, Long> implements IProdgodownentryDao {

}
