package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Pourpointsample;
import com.tonfun.tools.Error.ErrorCode;

public interface IPourpointsampleService extends IGenericSysService<Pourpointsample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyPourpointsample (Long id,Pourpointsample pourpointsample);
}
