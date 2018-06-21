package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProductDao;
import com.tonfun.tools.Model.BSOne.Product;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductService;



@Service
public class ProductServiceImpl extends CGenericSysImpl<Product, Long> implements IProductService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
  @Autowired
  IProductDao productDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProduct (Long id,Product product) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Product preproduct=productDao.findById(id);
      preproduct=product;
      productDao.update(preproduct);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
