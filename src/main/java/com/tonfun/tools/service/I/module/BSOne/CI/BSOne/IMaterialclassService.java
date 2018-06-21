package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Materialclass;
import com.tonfun.tools.Error.ErrorCode;

public interface IMaterialclassService extends IGenericSysService<Materialclass, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterialclass (Long id,Materialclass materialclass);
}
