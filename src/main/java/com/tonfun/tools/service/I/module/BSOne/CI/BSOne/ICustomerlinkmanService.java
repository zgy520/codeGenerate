package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Customerlinkman;
import com.tonfun.tools.Error.ErrorCode;

public interface ICustomerlinkmanService extends IGenericSysService<Customerlinkman, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyCustomerlinkman (Long id,Customerlinkman customerlinkman);
}
