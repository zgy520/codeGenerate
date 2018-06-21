package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodspec;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdspecService extends IGenericSysService<Prodspec, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdspec (Long id,Prodspec prodspec);
}
