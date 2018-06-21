package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Testanalysisreport;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisreportDao;



@Repository
public class TestanalysisreportDaoImpl extends BSOneGenericDao<Testanalysisreport, Long> implements ITestanalysisreportDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisreportDaoImpl.class);
}
