package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Productionorder;
import com.tonfun.tools.Error.ErrorCode;

public interface IProductionorderService extends IGenericSysService<Productionorder, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProductionorder (Long id,Productionorder productionorder);
}
