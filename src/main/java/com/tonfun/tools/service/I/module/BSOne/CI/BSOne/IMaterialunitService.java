package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Materialunit;
import com.tonfun.tools.Error.ErrorCode;

public interface IMaterialunitService extends IGenericSysService<Materialunit, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterialunit (Long id,Materialunit materialunit);
}
