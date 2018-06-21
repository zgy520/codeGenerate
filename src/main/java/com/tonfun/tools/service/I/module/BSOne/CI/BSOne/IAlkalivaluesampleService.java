package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Alkalivaluesample;
import com.tonfun.tools.Error.ErrorCode;

public interface IAlkalivaluesampleService extends IGenericSysService<Alkalivaluesample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyAlkalivaluesample (Long id,Alkalivaluesample alkalivaluesample);
}
