package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Organization;
import com.tonfun.tools.Error.ErrorCode;

public interface IOrganizationService extends IGenericSysService<Organization, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyOrganization (Long id,Organization organization);
}
