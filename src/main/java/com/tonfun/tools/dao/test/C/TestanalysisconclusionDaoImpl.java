package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Testanalysisconclusion;
import com.tonfun.tools.dao.test.I.ITestanalysisconclusionDao;



@Repository
public class TestanalysisconclusionDaoImpl extends SystemGenericDao<Testanalysisconclusion, Long> implements ITestanalysisconclusionDao {

}
