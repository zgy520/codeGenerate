package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Testanalysisreport;
import com.tonfun.tools.dao.test.I.ITestanalysisreportDao;



@Repository
public class TestanalysisreportDaoImpl extends SystemGenericDao<Testanalysisreport, Long> implements ITestanalysisreportDao {

}
