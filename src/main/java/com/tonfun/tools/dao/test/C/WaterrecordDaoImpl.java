package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Waterrecord;
import com.tonfun.tools.dao.test.I.IWaterrecordDao;



@Repository
public class WaterrecordDaoImpl extends SystemGenericDao<Waterrecord, Long> implements IWaterrecordDao {

}
