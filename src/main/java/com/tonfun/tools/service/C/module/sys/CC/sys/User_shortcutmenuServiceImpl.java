package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IUser_shortcutmenuDao;
import com.tonfun.tools.Model.sys.User_shortcutmenu;
import com.tonfun.tools.service.I.module.sys.CI.sys.IUser_shortcutmenuService;



@Service
public class User_shortcutmenuServiceImpl extends CGenericSysImpl<User_shortcutmenu, Long> implements IUser_shortcutmenuService {
  private static final Logger LOGGER = LoggerFactory.getLogger(User_shortcutmenuServiceImpl.class);
  @Autowired
  IUser_shortcutmenuDao user_shortcutmenuDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyUser_shortcutmenu (Long id,User_shortcutmenu user_shortcutmenu) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      User_shortcutmenu preuser_shortcutmenu=user_shortcutmenuDao.findById(id);
      preuser_shortcutmenu=user_shortcutmenu;
      user_shortcutmenuDao.update(preuser_shortcutmenu);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
