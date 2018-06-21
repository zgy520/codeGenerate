package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.User;
import com.tonfun.tools.dao.test.I.sys.IUserDao;



@Repository
public class UserDaoImpl extends SystemGenericDao<User, Long> implements IUserDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
}
