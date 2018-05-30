package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Watersample;
import com.tonfun.tools.dao.test.I.IWatersampleDao;



@Repository
public class WatersampleDaoImpl extends SystemGenericDao<Watersample, Long> implements IWatersampleDao {

}
