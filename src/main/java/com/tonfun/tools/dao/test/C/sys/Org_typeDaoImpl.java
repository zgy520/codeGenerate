package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Org_type;
import com.tonfun.tools.dao.test.I.sys.IOrg_typeDao;



@Repository
public class Org_typeDaoImpl extends SystemGenericDao<Org_type, Long> implements IOrg_typeDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(Org_typeDaoImpl.class);
}
