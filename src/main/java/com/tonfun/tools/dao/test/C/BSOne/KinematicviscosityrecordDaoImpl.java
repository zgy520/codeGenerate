package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Kinematicviscosityrecord;
import com.tonfun.tools.dao.test.I.BSOne.IKinematicviscosityrecordDao;



@Repository
public class KinematicviscosityrecordDaoImpl extends BSOneGenericDao<Kinematicviscosityrecord, Long> implements IKinematicviscosityrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(KinematicviscosityrecordDaoImpl.class);
}
