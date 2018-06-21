package com.tonfun.tools.service.C.module.sys.CC.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.sys.IOrg_typeDao;
import com.tonfun.tools.Model.sys.Org_type;
import com.tonfun.tools.service.I.module.sys.CI.sys.IOrg_typeService;



@Service
public class Org_typeServiceImpl extends CGenericSysImpl<Org_type, Long> implements IOrg_typeService {
  private static final Logger LOGGER = LoggerFactory.getLogger(Org_typeServiceImpl.class);
  @Autowired
  IOrg_typeDao org_typeDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyOrg_type (Long id,Org_type org_type) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Org_type preorg_type=org_typeDao.findById(id);
      preorg_type=org_type;
      org_typeDao.update(preorg_type);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
