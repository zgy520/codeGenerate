package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Manager;
import com.tonfun.tools.Error.ErrorCode;

public interface IManagerService extends IGenericSysService<Manager, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyManager (Long id,Manager manager);
}
