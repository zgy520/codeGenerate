package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Productionteam;
import com.tonfun.tools.Error.ErrorCode;

public interface IProductionteamService extends IGenericSysService<Productionteam, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProductionteam (Long id,Productionteam productionteam);
}
