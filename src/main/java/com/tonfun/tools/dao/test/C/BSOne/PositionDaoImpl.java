package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Position;
import com.tonfun.tools.dao.test.I.BSOne.IPositionDao;



@Repository
public class PositionDaoImpl extends BSOneGenericDao<Position, Long> implements IPositionDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PositionDaoImpl.class);
}
