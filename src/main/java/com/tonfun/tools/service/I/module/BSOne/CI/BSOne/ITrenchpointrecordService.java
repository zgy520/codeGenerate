package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Trenchpointrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface ITrenchpointrecordService extends IGenericSysService<Trenchpointrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTrenchpointrecord (Long id,Trenchpointrecord trenchpointrecord);
}
