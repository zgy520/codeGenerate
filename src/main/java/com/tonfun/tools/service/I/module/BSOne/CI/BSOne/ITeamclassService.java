package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Teamclass;
import com.tonfun.tools.Error.ErrorCode;

public interface ITeamclassService extends IGenericSysService<Teamclass, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTeamclass (Long id,Teamclass teamclass);
}
