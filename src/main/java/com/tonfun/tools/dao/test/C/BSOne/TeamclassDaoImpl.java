package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Teamclass;
import com.tonfun.tools.dao.test.I.BSOne.ITeamclassDao;



@Repository
public class TeamclassDaoImpl extends BSOneGenericDao<Teamclass, Long> implements ITeamclassDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(TeamclassDaoImpl.class);
}
