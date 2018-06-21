package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.User_shortcutmenu;
import com.tonfun.tools.dao.test.I.sys.IUser_shortcutmenuDao;



@Repository
public class User_shortcutmenuDaoImpl extends SystemGenericDao<User_shortcutmenu, Long> implements IUser_shortcutmenuDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(User_shortcutmenuDaoImpl.class);
}
