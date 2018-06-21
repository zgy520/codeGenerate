package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IRoleDao;
import com.tonfun.tools.Model.sys.Role;
import com.tonfun.tools.service.I.module.sys.CI.sys.IRoleService;



@Service
public class RoleServiceImpl extends CGenericSysImpl<Role, Long> implements IRoleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
  @Autowired
  IRoleDao roleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyRole (Long id,Role role) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Role prerole=roleDao.findById(id);
      prerole=role;
      roleDao.update(prerole);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
