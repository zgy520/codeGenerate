package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Produnit;
import com.tonfun.tools.dao.test.I.IProdunitDao;



@Repository
public class ProdunitDaoImpl extends SystemGenericDao<Produnit, Long> implements IProdunitDao {

}
