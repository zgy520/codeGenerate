package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Densityrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IDensityrecordService extends IGenericSysService<Densityrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyDensityrecord (Long id,Densityrecord densityrecord);
}
