package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodgodownentrydetail;
import com.tonfun.tools.dao.test.I.IProdgodownentrydetailDao;



@Repository
public class ProdgodownentrydetailDaoImpl extends SystemGenericDao<Prodgodownentrydetail, Long> implements IProdgodownentrydetailDao {

}
