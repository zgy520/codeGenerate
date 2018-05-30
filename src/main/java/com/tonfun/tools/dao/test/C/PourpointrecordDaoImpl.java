package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Pourpointrecord;
import com.tonfun.tools.dao.test.I.IPourpointrecordDao;



@Repository
public class PourpointrecordDaoImpl extends SystemGenericDao<Pourpointrecord, Long> implements IPourpointrecordDao {

}
