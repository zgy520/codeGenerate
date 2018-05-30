package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodspec;
import com.tonfun.tools.dao.test.I.IProdspecDao;



@Repository
public class ProdspecDaoImpl extends SystemGenericDao<Prodspec, Long> implements IProdspecDao {

}
