package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Diluent;
import com.tonfun.tools.dao.test.I.IDiluentDao;



@Repository
public class DiluentDaoImpl extends SystemGenericDao<Diluent, Long> implements IDiluentDao {

}
