package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Testanalysisdetail;
import com.tonfun.tools.dao.test.I.ITestanalysisdetailDao;



@Repository
public class TestanalysisdetailDaoImpl extends SystemGenericDao<Testanalysisdetail, Long> implements ITestanalysisdetailDao {

}
