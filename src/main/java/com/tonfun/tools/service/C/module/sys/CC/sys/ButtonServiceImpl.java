package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IButtonDao;
import com.tonfun.tools.Model.sys.Button;
import com.tonfun.tools.service.I.module.sys.CI.sys.IButtonService;



@Service
public class ButtonServiceImpl extends CGenericSysImpl<Button, Long> implements IButtonService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ButtonServiceImpl.class);
  @Autowired
  IButtonDao buttonDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyButton (Long id,Button button) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Button prebutton=buttonDao.findById(id);
      prebutton=button;
      buttonDao.update(prebutton);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
