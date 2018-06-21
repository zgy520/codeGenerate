package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Acidvaluesample;
import com.tonfun.tools.Error.ErrorCode;

public interface IAcidvaluesampleService extends IGenericSysService<Acidvaluesample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyAcidvaluesample (Long id,Acidvaluesample acidvaluesample);
}
