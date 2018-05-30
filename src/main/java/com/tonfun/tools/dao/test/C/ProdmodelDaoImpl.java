package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodmodel;
import com.tonfun.tools.dao.test.I.IProdmodelDao;



@Repository
public class ProdmodelDaoImpl extends SystemGenericDao<Prodmodel, Long> implements IProdmodelDao {

}
