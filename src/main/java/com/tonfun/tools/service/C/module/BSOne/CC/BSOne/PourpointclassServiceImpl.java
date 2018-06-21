package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IPourpointclassDao;
import com.tonfun.tools.Model.BSOne.Pourpointclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IPourpointclassService;



@Service
public class PourpointclassServiceImpl extends CGenericSysImpl<Pourpointclass, Long> implements IPourpointclassService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PourpointclassServiceImpl.class);
  @Autowired
  IPourpointclassDao pourpointclassDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyPourpointclass (Long id,Pourpointclass pourpointclass) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Pourpointclass prepourpointclass=pourpointclassDao.findById(id);
      prepourpointclass=pourpointclass;
      pourpointclassDao.update(prepourpointclass);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
