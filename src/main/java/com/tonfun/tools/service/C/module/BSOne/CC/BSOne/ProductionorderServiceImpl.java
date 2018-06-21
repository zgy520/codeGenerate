package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProductionorderDao;
import com.tonfun.tools.Model.BSOne.Productionorder;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductionorderService;



@Service
public class ProductionorderServiceImpl extends CGenericSysImpl<Productionorder, Long> implements IProductionorderService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionorderServiceImpl.class);
  @Autowired
  IProductionorderDao productionorderDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProductionorder (Long id,Productionorder productionorder) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Productionorder preproductionorder=productionorderDao.findById(id);
      preproductionorder=productionorder;
      productionorderDao.update(preproductionorder);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
