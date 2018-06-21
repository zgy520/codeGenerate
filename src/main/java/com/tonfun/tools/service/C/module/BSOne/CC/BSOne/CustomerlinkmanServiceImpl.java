package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ICustomerlinkmanDao;
import com.tonfun.tools.Model.BSOne.Customerlinkman;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ICustomerlinkmanService;



@Service
public class CustomerlinkmanServiceImpl extends CGenericSysImpl<Customerlinkman, Long> implements ICustomerlinkmanService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerlinkmanServiceImpl.class);
  @Autowired
  ICustomerlinkmanDao customerlinkmanDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyCustomerlinkman (Long id,Customerlinkman customerlinkman) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Customerlinkman precustomerlinkman=customerlinkmanDao.findById(id);
      precustomerlinkman=customerlinkman;
      customerlinkmanDao.update(precustomerlinkman);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
