package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IGodownkeeperDao;
import com.tonfun.tools.Model.BSOne.Godownkeeper;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IGodownkeeperService;



@Service
public class GodownkeeperServiceImpl extends CGenericSysImpl<Godownkeeper, Long> implements IGodownkeeperService {
  private static final Logger LOGGER = LoggerFactory.getLogger(GodownkeeperServiceImpl.class);
  @Autowired
  IGodownkeeperDao godownkeeperDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyGodownkeeper (Long id,Godownkeeper godownkeeper) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Godownkeeper pregodownkeeper=godownkeeperDao.findById(id);
      pregodownkeeper=godownkeeper;
      godownkeeperDao.update(pregodownkeeper);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
