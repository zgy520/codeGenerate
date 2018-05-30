package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Acidvaluerecord;
import com.tonfun.tools.dao.test.I.IAcidvaluerecordDao;



@Repository
public class AcidvaluerecordDaoImpl extends SystemGenericDao<Acidvaluerecord, Long> implements IAcidvaluerecordDao {

}
