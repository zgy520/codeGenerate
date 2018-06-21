package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Godownkeeper;
import com.tonfun.tools.Error.ErrorCode;

public interface IGodownkeeperService extends IGenericSysService<Godownkeeper, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyGodownkeeper (Long id,Godownkeeper godownkeeper);
}
