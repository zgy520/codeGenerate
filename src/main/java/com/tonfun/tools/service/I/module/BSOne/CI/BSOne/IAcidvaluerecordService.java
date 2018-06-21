package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Acidvaluerecord;
import com.tonfun.tools.Error.ErrorCode;

public interface IAcidvaluerecordService extends IGenericSysService<Acidvaluerecord, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyAcidvaluerecord (Long id,Acidvaluerecord acidvaluerecord);
}
