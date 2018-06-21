package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Role;
import com.tonfun.tools.dao.test.I.sys.IRoleDao;



@Repository
public class RoleDaoImpl extends SystemGenericDao<Role, Long> implements IRoleDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);
}
