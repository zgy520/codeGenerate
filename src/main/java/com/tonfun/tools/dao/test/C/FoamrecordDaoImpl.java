package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Foamrecord;
import com.tonfun.tools.dao.test.I.IFoamrecordDao;



@Repository
public class FoamrecordDaoImpl extends SystemGenericDao<Foamrecord, Long> implements IFoamrecordDao {

}
