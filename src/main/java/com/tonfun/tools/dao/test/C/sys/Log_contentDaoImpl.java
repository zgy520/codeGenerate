package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Log_content;
import com.tonfun.tools.dao.test.I.sys.ILog_contentDao;



@Repository
public class Log_contentDaoImpl extends SystemGenericDao<Log_content, Long> implements ILog_contentDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(Log_contentDaoImpl.class);
}
