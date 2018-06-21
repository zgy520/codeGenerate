package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.ILogDao;
import com.tonfun.tools.Model.sys.Log;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILogService;



@Service
public class LogServiceImpl extends CGenericSysImpl<Log, Long> implements ILogService {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);
  @Autowired
  ILogDao logDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyLog (Long id,Log log) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Log prelog=logDao.findById(id);
      prelog=log;
      logDao.update(prelog);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
