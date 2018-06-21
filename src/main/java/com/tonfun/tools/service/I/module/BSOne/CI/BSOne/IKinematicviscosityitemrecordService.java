package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Kinematicviscosityitemrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IKinematicviscosityitemrecordService extends IGenericSysService<Kinematicviscosityitemrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyKinematicviscosityitemrecord (Long id,Kinematicviscosityitemrecord kinematicviscosityitemrecord);
}
