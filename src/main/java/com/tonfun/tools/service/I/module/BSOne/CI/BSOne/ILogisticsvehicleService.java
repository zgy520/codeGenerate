package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Logisticsvehicle;
import com.tonfun.tools.Error.ErrorCode;

public interface ILogisticsvehicleService extends IGenericSysService<Logisticsvehicle, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLogisticsvehicle (Long id,Logisticsvehicle logisticsvehicle);
}
