package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Foamitem;
import com.tonfun.tools.Error.ErrorCode;

public interface IFoamitemService extends IGenericSysService<Foamitem, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyFoamitem (Long id,Foamitem foamitem);
}
