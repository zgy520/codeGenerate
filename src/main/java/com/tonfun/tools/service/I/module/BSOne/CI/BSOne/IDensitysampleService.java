package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Densitysample;
import com.tonfun.tools.Error.ErrorCode;

public interface IDensitysampleService extends IGenericSysService<Densitysample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyDensitysample (Long id,Densitysample densitysample);
}
