package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiessample;
import com.tonfun.tools.Error.ErrorCode;

public interface IMechanicalimpuritiessampleService extends IGenericSysService<Mechanicalimpuritiessample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMechanicalimpuritiessample (Long id,Mechanicalimpuritiessample mechanicalimpuritiessample);
}
