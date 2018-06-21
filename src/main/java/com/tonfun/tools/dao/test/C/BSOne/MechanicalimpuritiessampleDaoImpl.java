package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiessample;
import com.tonfun.tools.dao.test.I.BSOne.IMechanicalimpuritiessampleDao;



@Repository
public class MechanicalimpuritiessampleDaoImpl extends BSOneGenericDao<Mechanicalimpuritiessample, Long> implements IMechanicalimpuritiessampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MechanicalimpuritiessampleDaoImpl.class);
}
