package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Productionorderhistory;
import com.tonfun.tools.Error.ErrorCode;

public interface IProductionorderhistoryService extends IGenericSysService<Productionorderhistory, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProductionorderhistory (Long id,Productionorderhistory productionorderhistory);
}
