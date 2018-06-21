package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Proddeliveryorderhistory;
import com.tonfun.tools.Error.ErrorCode;

public interface IProddeliveryorderhistoryService extends IGenericSysService<Proddeliveryorderhistory, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProddeliveryorderhistory (Long id,Proddeliveryorderhistory proddeliveryorderhistory);
}
