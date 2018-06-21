package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Org_type;
import com.tonfun.tools.Error.ErrorCode;

public interface IOrg_typeService extends IGenericSysService<Org_type, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyOrg_type (Long id,Org_type org_type);
}
