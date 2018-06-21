package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Waterrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IWaterrecordService extends IGenericSysService<Waterrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyWaterrecord (Long id,Waterrecord waterrecord);
}
