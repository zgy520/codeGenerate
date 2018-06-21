package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Inventorylog;
import com.tonfun.tools.Error.ErrorCode;

public interface IInventorylogService extends IGenericSysService<Inventorylog, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyInventorylog (Long id,Inventorylog inventorylog);
}
