package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodgodownentryhistory;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdgodownentryhistoryService extends IGenericSysService<Prodgodownentryhistory, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdgodownentryhistory (Long id,Prodgodownentryhistory prodgodownentryhistory);
}
