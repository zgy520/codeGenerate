package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Prodmodel;
import com.tonfun.tools.Error.ErrorCode;

public interface IProdmodelService extends IGenericSysService<Prodmodel, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProdmodel (Long id,Prodmodel prodmodel);
}
