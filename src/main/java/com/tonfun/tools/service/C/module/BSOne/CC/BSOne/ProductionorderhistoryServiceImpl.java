package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProductionorderhistoryDao;
import com.tonfun.tools.Model.BSOne.Productionorderhistory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductionorderhistoryService;



@Service
public class ProductionorderhistoryServiceImpl extends CGenericSysImpl<Productionorderhistory, Long> implements IProductionorderhistoryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionorderhistoryServiceImpl.class);
  @Autowired
  IProductionorderhistoryDao productionorderhistoryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProductionorderhistory (Long id,Productionorderhistory productionorderhistory) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Productionorderhistory preproductionorderhistory=productionorderhistoryDao.findById(id);
      preproductionorderhistory=productionorderhistory;
      productionorderhistoryDao.update(preproductionorderhistory);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
