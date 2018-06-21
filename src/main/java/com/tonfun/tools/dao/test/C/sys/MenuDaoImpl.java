package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Menu;
import com.tonfun.tools.dao.test.I.sys.IMenuDao;



@Repository
public class MenuDaoImpl extends SystemGenericDao<Menu, Long> implements IMenuDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(MenuDaoImpl.class);
}
