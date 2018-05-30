package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Proddeliveryorderdetail;
import com.tonfun.tools.dao.test.I.IProddeliveryorderdetailDao;



@Repository
public class ProddeliveryorderdetailDaoImpl extends SystemGenericDao<Proddeliveryorderdetail, Long> implements IProddeliveryorderdetailDao {

}
