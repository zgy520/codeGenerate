package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Flashrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IFlashrecordService extends IGenericSysService<Flashrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyFlashrecord (Long id,Flashrecord flashrecord);
}
