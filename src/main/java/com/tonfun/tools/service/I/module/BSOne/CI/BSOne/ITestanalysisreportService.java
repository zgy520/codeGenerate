package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Testanalysisreport;
import com.tonfun.tools.Error.ErrorCode;

public interface ITestanalysisreportService extends IGenericSysService<Testanalysisreport, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTestanalysisreport (Long id,Testanalysisreport testanalysisreport);
}
