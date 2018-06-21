package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Coppersheetcorrosionrecord;
import com.tonfun.tools.Error.ErrorCode;

public interface ICoppersheetcorrosionrecordService extends IGenericSysService<Coppersheetcorrosionrecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyCoppersheetcorrosionrecord (Long id,Coppersheetcorrosionrecord coppersheetcorrosionrecord);
}
