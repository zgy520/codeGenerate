package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProductionteammemberDao;
import com.tonfun.tools.Model.BSOne.Productionteammember;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductionteammemberService;



@Service
public class ProductionteammemberServiceImpl extends CGenericSysImpl<Productionteammember, Long> implements IProductionteammemberService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionteammemberServiceImpl.class);
  @Autowired
  IProductionteammemberDao productionteammemberDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProductionteammember (Long id,Productionteammember productionteammember) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Productionteammember preproductionteammember=productionteammemberDao.findById(id);
      preproductionteammember=productionteammember;
      productionteammemberDao.update(preproductionteammember);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
