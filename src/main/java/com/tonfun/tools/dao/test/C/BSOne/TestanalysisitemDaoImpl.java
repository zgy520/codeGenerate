package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Testanalysisitem;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisitemDao;



@Repository
public class TestanalysisitemDaoImpl extends BSOneGenericDao<Testanalysisitem, Long> implements ITestanalysisitemDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisitemDaoImpl.class);
}
