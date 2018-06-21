package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.User;
import com.tonfun.tools.Error.ErrorCode;

public interface IUserService extends IGenericSysService<User, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyUser (Long id,User user);
}
