package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Testanalysisitem;
import com.tonfun.tools.Error.ErrorCode;

public interface ITestanalysisitemService extends IGenericSysService<Testanalysisitem, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTestanalysisitem (Long id,Testanalysisitem testanalysisitem);
}
