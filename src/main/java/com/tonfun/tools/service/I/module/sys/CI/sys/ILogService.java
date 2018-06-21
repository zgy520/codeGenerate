package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Log;
import com.tonfun.tools.Error.ErrorCode;

public interface ILogService extends IGenericSysService<Log, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLog (Long id,Log log);
}
