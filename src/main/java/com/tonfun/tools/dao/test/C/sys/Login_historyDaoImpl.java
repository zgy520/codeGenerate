package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Login_history;
import com.tonfun.tools.dao.test.I.sys.ILogin_historyDao;



@Repository
public class Login_historyDaoImpl extends SystemGenericDao<Login_history, Long> implements ILogin_historyDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(Login_historyDaoImpl.class);
}
