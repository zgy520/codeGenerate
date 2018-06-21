package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Demulsifyrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IDemulsifyrecordService extends IGenericSysService<Demulsifyrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyDemulsifyrecord (Long id,Demulsifyrecord demulsifyrecord);
}
