package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ILogisticsvehicleDao;
import com.tonfun.tools.Model.BSOne.Logisticsvehicle;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ILogisticsvehicleService;



@Service
public class LogisticsvehicleServiceImpl extends CGenericSysImpl<Logisticsvehicle, Long> implements ILogisticsvehicleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsvehicleServiceImpl.class);
  @Autowired
  ILogisticsvehicleDao logisticsvehicleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyLogisticsvehicle (Long id,Logisticsvehicle logisticsvehicle) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Logisticsvehicle prelogisticsvehicle=logisticsvehicleDao.findById(id);
      prelogisticsvehicle=logisticsvehicle;
      logisticsvehicleDao.update(prelogisticsvehicle);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
