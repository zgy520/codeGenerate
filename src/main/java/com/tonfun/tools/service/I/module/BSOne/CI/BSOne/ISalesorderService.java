package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Salesorder;
import com.tonfun.tools.Error.ErrorCode;

public interface ISalesorderService extends IGenericSysService<Salesorder, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifySalesorder (Long id,Salesorder salesorder);
}
