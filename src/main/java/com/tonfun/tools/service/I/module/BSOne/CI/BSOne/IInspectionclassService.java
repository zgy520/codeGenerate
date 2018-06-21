package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Inspectionclass;
import com.tonfun.tools.Error.ErrorCode;

public interface IInspectionclassService extends IGenericSysService<Inspectionclass, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyInspectionclass (Long id,Inspectionclass inspectionclass);
}
