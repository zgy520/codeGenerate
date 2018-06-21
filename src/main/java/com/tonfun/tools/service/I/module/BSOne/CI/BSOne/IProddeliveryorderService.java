package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Proddeliveryorder;
import com.tonfun.tools.Error.ErrorCode;

public interface IProddeliveryorderService extends IGenericSysService<Proddeliveryorder, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProddeliveryorder (Long id,Proddeliveryorder proddeliveryorder);
}
