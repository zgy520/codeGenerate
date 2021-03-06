package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.ILogin_historyDao;
import com.tonfun.tools.Model.sys.Login_history;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILogin_historyService;



@Service
public class Login_historyServiceImpl extends CGenericSysImpl<Login_history, Long> implements ILogin_historyService {
  private static final Logger LOGGER = LoggerFactory.getLogger(Login_historyServiceImpl.class);
  @Autowired
  ILogin_historyDao login_historyDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyLogin_history (Long id,Login_history login_history) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Login_history prelogin_history=login_historyDao.findById(id);
      prelogin_history=login_history;
      login_historyDao.update(prelogin_history);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
