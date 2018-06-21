package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Kinematicviscositysample;
import com.tonfun.tools.dao.test.I.BSOne.IKinematicviscositysampleDao;



@Repository
public class KinematicviscositysampleDaoImpl extends BSOneGenericDao<Kinematicviscositysample, Long> implements IKinematicviscositysampleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(KinematicviscositysampleDaoImpl.class);
}
