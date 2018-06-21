package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiesrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IMechanicalimpuritiesrecordService extends IGenericSysService<Mechanicalimpuritiesrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMechanicalimpuritiesrecord (Long id,Mechanicalimpuritiesrecord mechanicalimpuritiesrecord);
}
