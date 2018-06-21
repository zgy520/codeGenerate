package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Kinematicviscosityitemrecord;
import com.tonfun.tools.dao.test.I.BSOne.IKinematicviscosityitemrecordDao;



@Repository
public class KinematicviscosityitemrecordDaoImpl extends BSOneGenericDao<Kinematicviscosityitemrecord, Long> implements IKinematicviscosityitemrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(KinematicviscosityitemrecordDaoImpl.class);
}
