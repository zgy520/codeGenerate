package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Analysisreportclass;
import com.tonfun.tools.dao.test.I.BSOne.IAnalysisreportclassDao;



@Repository
public class AnalysisreportclassDaoImpl extends BSOneGenericDao<Analysisreportclass, Long> implements IAnalysisreportclassDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(AnalysisreportclassDaoImpl.class);
}
