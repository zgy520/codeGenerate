package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Materialbrand;
import com.tonfun.tools.Error.ErrorCode;

public interface IMaterialbrandService extends IGenericSysService<Materialbrand, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterialbrand (Long id,Materialbrand materialbrand);
}
