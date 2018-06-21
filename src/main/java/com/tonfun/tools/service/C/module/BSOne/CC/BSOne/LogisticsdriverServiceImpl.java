package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ILogisticsdriverDao;
import com.tonfun.tools.Model.BSOne.Logisticsdriver;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ILogisticsdriverService;



@Service
public class LogisticsdriverServiceImpl extends CGenericSysImpl<Logisticsdriver, Long> implements ILogisticsdriverService {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsdriverServiceImpl.class);
  @Autowired
  ILogisticsdriverDao logisticsdriverDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyLogisticsdriver (Long id,Logisticsdriver logisticsdriver) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Logisticsdriver prelogisticsdriver=logisticsdriverDao.findById(id);
      prelogisticsdriver=logisticsdriver;
      logisticsdriverDao.update(prelogisticsdriver);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
