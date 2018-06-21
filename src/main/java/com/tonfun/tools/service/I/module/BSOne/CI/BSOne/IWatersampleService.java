package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Watersample;
import com.tonfun.tools.Error.ErrorCode;

public interface IWatersampleService extends IGenericSysService<Watersample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyWatersample (Long id,Watersample watersample);
}
