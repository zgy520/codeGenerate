package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Kinematicviscosityrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IKinematicviscosityrecordService extends IGenericSysService<Kinematicviscosityrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyKinematicviscosityrecord (Long id,Kinematicviscosityrecord kinematicviscosityrecord);
}
