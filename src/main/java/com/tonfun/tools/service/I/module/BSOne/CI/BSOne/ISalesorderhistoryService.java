package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Salesorderhistory;
import com.tonfun.tools.Error.ErrorCode;

public interface ISalesorderhistoryService extends IGenericSysService<Salesorderhistory, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifySalesorderhistory (Long id,Salesorderhistory salesorderhistory);
}
