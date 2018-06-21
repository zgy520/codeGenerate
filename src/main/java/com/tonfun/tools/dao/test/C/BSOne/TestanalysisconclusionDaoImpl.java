package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Testanalysisconclusion;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisconclusionDao;



@Repository
public class TestanalysisconclusionDaoImpl extends BSOneGenericDao<Testanalysisconclusion, Long> implements ITestanalysisconclusionDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisconclusionDaoImpl.class);
}
