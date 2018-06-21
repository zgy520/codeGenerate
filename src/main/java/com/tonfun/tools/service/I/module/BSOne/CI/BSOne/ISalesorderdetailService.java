package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Salesorderdetail;
import com.tonfun.tools.Error.ErrorCode;

public interface ISalesorderdetailService extends IGenericSysService<Salesorderdetail, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifySalesorderdetail (Long id,Salesorderdetail salesorderdetail);
}
