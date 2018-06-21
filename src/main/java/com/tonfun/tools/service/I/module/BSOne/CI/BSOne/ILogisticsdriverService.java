package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Logisticsdriver;
import com.tonfun.tools.Error.ErrorCode;

public interface ILogisticsdriverService extends IGenericSysService<Logisticsdriver, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLogisticsdriver (Long id,Logisticsdriver logisticsdriver);
}
