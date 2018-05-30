package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Inspectionrecord;
import com.tonfun.tools.dao.test.I.IInspectionrecordDao;



@Repository
public class InspectionrecordDaoImpl extends SystemGenericDao<Inspectionrecord, Long> implements IInspectionrecordDao {

}
