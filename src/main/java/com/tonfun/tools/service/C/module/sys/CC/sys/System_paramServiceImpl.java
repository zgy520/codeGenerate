package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.ISystem_paramDao;
import com.tonfun.tools.Model.sys.System_param;
import com.tonfun.tools.service.I.module.sys.CI.sys.ISystem_paramService;



@Service
public class System_paramServiceImpl extends CGenericSysImpl<System_param, Long> implements ISystem_paramService {
  private static final Logger LOGGER = LoggerFactory.getLogger(System_paramServiceImpl.class);
  @Autowired
  ISystem_paramDao system_paramDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifySystem_param (Long id,System_param system_param) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      System_param presystem_param=system_paramDao.findById(id);
      presystem_param=system_param;
      system_paramDao.update(presystem_param);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
