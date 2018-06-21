package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Role;
import com.tonfun.tools.Error.ErrorCode;

public interface IRoleService extends IGenericSysService<Role, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyRole (Long id,Role role);
}
