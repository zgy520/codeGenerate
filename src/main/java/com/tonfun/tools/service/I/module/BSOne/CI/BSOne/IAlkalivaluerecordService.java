package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Alkalivaluerecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IAlkalivaluerecordService extends IGenericSysService<Alkalivaluerecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyAlkalivaluerecord (Long id,Alkalivaluerecord alkalivaluerecord);
}
