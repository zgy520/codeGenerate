package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodgodownentry;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdgodownentryService extends IGenericSysService<Prodgodownentry, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdgodownentry (Long id,Prodgodownentry prodgodownentry);
}
