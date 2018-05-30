package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Pourpointclass;
import com.tonfun.tools.dao.test.I.IPourpointclassDao;



@Repository
public class PourpointclassDaoImpl extends SystemGenericDao<Pourpointclass, Long> implements IPourpointclassDao {

}
