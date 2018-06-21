package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Product;
import com.tonfun.tools.Error.ErrorCode;

public interface IProductService extends IGenericSysService<Product, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProduct (Long id,Product product);
}
