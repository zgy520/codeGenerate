package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IManagerDao;
import com.tonfun.tools.Model.BSOne.Manager;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IManagerService;



@Service
public class ManagerServiceImpl extends CGenericSysImpl<Manager, Long> implements IManagerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);
  @Autowired
  IManagerDao managerDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyManager (Long id,Manager manager) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Manager premanager=managerDao.findById(id);
      premanager=manager;
      managerDao.update(premanager);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
