package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Teamclass;
import com.tonfun.tools.dao.test.I.ITeamclassDao;



@Repository
public class TeamclassDaoImpl extends SystemGenericDao<Teamclass, Long> implements ITeamclassDao {

}
