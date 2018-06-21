package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Inventory;
import com.tonfun.tools.Error.ErrorCode;

public interface IInventoryService extends IGenericSysService<Inventory, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyInventory (Long id,Inventory inventory);
}
