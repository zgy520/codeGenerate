package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Position;
import com.tonfun.tools.Error.ErrorCode;

public interface IPositionService extends IGenericSysService<Position, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyPosition (Long id,Position position);
}
