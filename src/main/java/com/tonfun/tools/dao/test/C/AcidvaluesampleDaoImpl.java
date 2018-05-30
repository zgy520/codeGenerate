package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Acidvaluesample;
import com.tonfun.tools.dao.test.I.IAcidvaluesampleDao;



@Repository
public class AcidvaluesampleDaoImpl extends SystemGenericDao<Acidvaluesample, Long> implements IAcidvaluesampleDao {

}
