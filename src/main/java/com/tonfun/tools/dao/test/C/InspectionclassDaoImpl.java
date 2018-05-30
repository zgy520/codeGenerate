package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Inspectionclass;
import com.tonfun.tools.dao.test.I.IInspectionclassDao;



@Repository
public class InspectionclassDaoImpl extends SystemGenericDao<Inspectionclass, Long> implements IInspectionclassDao {

}
