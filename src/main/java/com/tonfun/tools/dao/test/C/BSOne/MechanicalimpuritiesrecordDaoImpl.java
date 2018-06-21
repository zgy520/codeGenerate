package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiesrecord;
import com.tonfun.tools.dao.test.I.BSOne.IMechanicalimpuritiesrecordDao;



@Repository
public class MechanicalimpuritiesrecordDaoImpl extends BSOneGenericDao<Mechanicalimpuritiesrecord, Long> implements IMechanicalimpuritiesrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MechanicalimpuritiesrecordDaoImpl.class);
}
