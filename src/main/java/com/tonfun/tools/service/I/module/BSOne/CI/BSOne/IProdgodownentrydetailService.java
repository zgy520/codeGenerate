package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodgodownentrydetail;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdgodownentrydetailService extends IGenericSysService<Prodgodownentrydetail, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdgodownentrydetail (Long id,Prodgodownentrydetail prodgodownentrydetail);
}
