package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Acidvaluesample;
import com.tonfun.tools.dao.test.I.BSOne.IAcidvaluesampleDao;



@Repository
public class AcidvaluesampleDaoImpl extends BSOneGenericDao<Acidvaluesample, Long> implements IAcidvaluesampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcidvaluesampleDaoImpl.class);
}
