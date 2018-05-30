package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Densityrecord;
import com.tonfun.tools.dao.test.I.IDensityrecordDao;



@Repository
public class DensityrecordDaoImpl extends SystemGenericDao<Densityrecord, Long> implements IDensityrecordDao {

}
