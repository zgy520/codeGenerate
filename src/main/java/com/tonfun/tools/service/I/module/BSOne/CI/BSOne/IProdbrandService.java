package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodbrand;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdbrandService extends IGenericSysService<Prodbrand, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdbrand (Long id,Prodbrand prodbrand);
}
