package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Materialmodel;
import com.tonfun.tools.Error.ErrorCode;

public interface IMaterialmodelService extends IGenericSysService<Materialmodel, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterialmodel (Long id,Materialmodel materialmodel);
}
