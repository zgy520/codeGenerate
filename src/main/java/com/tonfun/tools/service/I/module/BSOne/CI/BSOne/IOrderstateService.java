package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Orderstate;
import com.tonfun.tools.Error.ErrorCode;

public interface IOrderstateService extends IGenericSysService<Orderstate, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyOrderstate (Long id,Orderstate orderstate);
}
