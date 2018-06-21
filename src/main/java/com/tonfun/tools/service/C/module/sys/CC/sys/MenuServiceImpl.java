package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IMenuDao;
import com.tonfun.tools.Model.sys.Menu;
import com.tonfun.tools.service.I.module.sys.CI.sys.IMenuService;



@Service
public class MenuServiceImpl extends CGenericSysImpl<Menu, Long> implements IMenuService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
  @Autowired
  IMenuDao menuDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMenu (Long id,Menu menu) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Menu premenu=menuDao.findById(id);
      premenu=menu;
      menuDao.update(premenu);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
