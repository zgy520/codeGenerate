package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IPourpointsampleDao;
import com.tonfun.tools.Model.BSOne.Pourpointsample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IPourpointsampleService;



@Service
public class PourpointsampleServiceImpl extends CGenericSysImpl<Pourpointsample, Long> implements IPourpointsampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PourpointsampleServiceImpl.class);
  @Autowired
  IPourpointsampleDao pourpointsampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyPourpointsample (Long id,Pourpointsample pourpointsample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Pourpointsample prepourpointsample=pourpointsampleDao.findById(id);
      prepourpointsample=pourpointsample;
      pourpointsampleDao.update(prepourpointsample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
