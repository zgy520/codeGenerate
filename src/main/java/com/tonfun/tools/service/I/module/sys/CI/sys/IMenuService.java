package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Menu;
import com.tonfun.tools.Error.ErrorCode;

public interface IMenuService extends IGenericSysService<Menu, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMenu (Long id,Menu menu);
}
