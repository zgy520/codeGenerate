package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Alkalivaluesample;
import com.tonfun.tools.dao.test.I.IAlkalivaluesampleDao;



@Repository
public class AlkalivaluesampleDaoImpl extends SystemGenericDao<Alkalivaluesample, Long> implements IAlkalivaluesampleDao {

}
