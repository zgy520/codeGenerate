package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.ILog_contentDao;
import com.tonfun.tools.Model.sys.Log_content;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILog_contentService;



@Service
public class Log_contentServiceImpl extends CGenericSysImpl<Log_content, Long> implements ILog_contentService {
  private static final Logger LOGGER = LoggerFactory.getLogger(Log_contentServiceImpl.class);
  @Autowired
  ILog_contentDao log_contentDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyLog_content (Long id,Log_content log_content) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Log_content prelog_content=log_contentDao.findById(id);
      prelog_content=log_content;
      log_contentDao.update(prelog_content);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
