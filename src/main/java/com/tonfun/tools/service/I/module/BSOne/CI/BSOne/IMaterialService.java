package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Material;
import com.tonfun.tools.Error.ErrorCode;

public interface IMaterialService extends IGenericSysService<Material, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterial (Long id,Material material);
}
