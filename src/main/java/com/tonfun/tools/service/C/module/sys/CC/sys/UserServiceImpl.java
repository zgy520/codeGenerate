package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IUserDao;
import com.tonfun.tools.Model.sys.User;
import com.tonfun.tools.service.I.module.sys.CI.sys.IUserService;



@Service
public class UserServiceImpl extends CGenericSysImpl<User, Long> implements IUserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  IUserDao userDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyUser (Long id,User user) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      User preuser=userDao.findById(id);
      preuser=user;
      userDao.update(preuser);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
