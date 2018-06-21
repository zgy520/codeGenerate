package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProductionteamDao;
import com.tonfun.tools.Model.BSOne.Productionteam;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductionteamService;



@Service
public class ProductionteamServiceImpl extends CGenericSysImpl<Productionteam, Long> implements IProductionteamService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionteamServiceImpl.class);
  @Autowired
  IProductionteamDao productionteamDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProductionteam (Long id,Productionteam productionteam) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Productionteam preproductionteam=productionteamDao.findById(id);
      preproductionteam=productionteam;
      productionteamDao.update(preproductionteam);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
