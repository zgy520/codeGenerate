package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Testanalysisconclusion;
import com.tonfun.tools.Error.ErrorCode;

public interface ITestanalysisconclusionService extends IGenericSysService<Testanalysisconclusion, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTestanalysisconclusion (Long id,Testanalysisconclusion testanalysisconclusion);
}
