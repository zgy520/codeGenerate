package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Prodbrand;
import com.tonfun.tools.dao.test.I.IProdbrandDao;



@Repository
public class ProdbrandDaoImpl extends SystemGenericDao<Prodbrand, Long> implements IProdbrandDao {

}
