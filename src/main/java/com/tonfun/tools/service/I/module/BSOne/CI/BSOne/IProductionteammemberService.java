package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Productionteammember;
import com.tonfun.tools.Error.ErrorCode;

public interface IProductionteammemberService extends IGenericSysService<Productionteammember, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProductionteammember (Long id,Productionteammember productionteammember);
}
