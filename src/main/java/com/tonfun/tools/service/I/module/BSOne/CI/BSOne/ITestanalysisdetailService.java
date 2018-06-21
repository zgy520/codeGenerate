package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Testanalysisdetail;
import com.tonfun.tools.Error.ErrorCode;

public interface ITestanalysisdetailService extends IGenericSysService<Testanalysisdetail, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTestanalysisdetail (Long id,Testanalysisdetail testanalysisdetail);
}
