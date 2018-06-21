package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Button;
import com.tonfun.tools.dao.test.I.sys.IButtonDao;



@Repository
public class ButtonDaoImpl extends SystemGenericDao<Button, Long> implements IButtonDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ButtonDaoImpl.class);
}
