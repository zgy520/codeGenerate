package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Diluent;
import com.tonfun.tools.Error.ErrorCode;

public interface IDiluentService extends IGenericSysService<Diluent, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyDiluent (Long id,Diluent diluent);
}
