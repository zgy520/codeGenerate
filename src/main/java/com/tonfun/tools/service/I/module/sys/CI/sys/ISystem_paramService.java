package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.System_param;
import com.tonfun.tools.Error.ErrorCode;

public interface ISystem_paramService extends IGenericSysService<System_param, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifySystem_param (Long id,System_param system_param);
}
