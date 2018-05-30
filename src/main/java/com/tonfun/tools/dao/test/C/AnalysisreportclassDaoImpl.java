package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Analysisreportclass;
import com.tonfun.tools.dao.test.I.IAnalysisreportclassDao;



@Repository
public class AnalysisreportclassDaoImpl extends SystemGenericDao<Analysisreportclass, Long> implements IAnalysisreportclassDao {

}
