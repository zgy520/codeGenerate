package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IOrganizationDao;
import com.tonfun.tools.Model.sys.Organization;
import com.tonfun.tools.service.I.module.sys.CI.sys.IOrganizationService;



@Service
public class OrganizationServiceImpl extends CGenericSysImpl<Organization, Long> implements IOrganizationService {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
  @Autowired
  IOrganizationDao organizationDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyOrganization (Long id,Organization organization) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Organization preorganization=organizationDao.findById(id);
      preorganization=organization;
      organizationDao.update(preorganization);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
