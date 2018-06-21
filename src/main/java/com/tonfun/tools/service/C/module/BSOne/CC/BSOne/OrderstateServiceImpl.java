package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IOrderstateDao;
import com.tonfun.tools.Model.BSOne.Orderstate;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IOrderstateService;



@Service
public class OrderstateServiceImpl extends CGenericSysImpl<Orderstate, Long> implements IOrderstateService {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderstateServiceImpl.class);
  @Autowired
  IOrderstateDao orderstateDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyOrderstate (Long id,Orderstate orderstate) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Orderstate preorderstate=orderstateDao.findById(id);
      preorderstate=orderstate;
      orderstateDao.update(preorderstate);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
