package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Proddeliveryorder;
import com.tonfun.tools.dao.test.I.IProddeliveryorderDao;



@Repository
public class ProddeliveryorderDaoImpl extends SystemGenericDao<Proddeliveryorder, Long> implements IProddeliveryorderDao {

}
