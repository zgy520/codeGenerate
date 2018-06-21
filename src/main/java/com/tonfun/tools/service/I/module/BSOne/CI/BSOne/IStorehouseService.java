package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Storehouse;
import com.tonfun.tools.Error.ErrorCode;

public interface IStorehouseService extends IGenericSysService<Storehouse, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyStorehouse (Long id,Storehouse storehouse);
}
