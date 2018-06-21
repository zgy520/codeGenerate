package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Kinematicviscositysample;
import com.tonfun.tools.Error.ErrorCode;

public interface IKinematicviscositysampleService extends IGenericSysService<Kinematicviscositysample, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyKinematicviscositysample (Long id,Kinematicviscositysample kinematicviscositysample);
}
