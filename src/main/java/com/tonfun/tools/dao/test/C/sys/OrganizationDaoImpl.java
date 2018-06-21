package com.tonfun.tools.dao.test.C.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.sys.Organization;
import com.tonfun.tools.dao.test.I.sys.IOrganizationDao;



@Repository
public class OrganizationDaoImpl extends SystemGenericDao<Organization, Long> implements IOrganizationDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationDaoImpl.class);
}
