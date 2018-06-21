package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Button;
import com.tonfun.tools.Error.ErrorCode;

public interface IButtonService extends IGenericSysService<Button, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyButton (Long id,Button button);
}
