package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Logisticscompany;
import com.tonfun.tools.Error.ErrorCode;

public interface ILogisticscompanyService extends IGenericSysService<Logisticscompany, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLogisticscompany (Long id,Logisticscompany logisticscompany);
}
