package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Acidvaluerecord;
import com.tonfun.tools.dao.test.I.BSOne.IAcidvaluerecordDao;



@Repository
public class AcidvaluerecordDaoImpl extends BSOneGenericDao<Acidvaluerecord, Long> implements IAcidvaluerecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcidvaluerecordDaoImpl.class);
}
