package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Pourpointrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IPourpointrecordService extends IGenericSysService<Pourpointrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyPourpointrecord (Long id,Pourpointrecord pourpointrecord);
}
