package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Analysisreportclass;
import com.tonfun.tools.Error.ErrorCode;

public interface IAnalysisreportclassService extends IGenericSysService<Analysisreportclass, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyAnalysisreportclass (Long id,Analysisreportclass analysisreportclass);
}
