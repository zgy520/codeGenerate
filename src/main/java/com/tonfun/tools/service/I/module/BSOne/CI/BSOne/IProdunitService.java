package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Produnit;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdunitService extends IGenericSysService<Produnit, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdunit (Long id,Produnit produnit);
}
