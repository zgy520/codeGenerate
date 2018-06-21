package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Login_history;
import com.tonfun.tools.Error.ErrorCode;

public interface ILogin_historyService extends IGenericSysService<Login_history, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLogin_history (Long id,Login_history login_history);
}
