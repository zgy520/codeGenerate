package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Pourpointsample;
import com.tonfun.tools.dao.test.I.IPourpointsampleDao;



@Repository
public class PourpointsampleDaoImpl extends SystemGenericDao<Pourpointsample, Long> implements IPourpointsampleDao {

}
