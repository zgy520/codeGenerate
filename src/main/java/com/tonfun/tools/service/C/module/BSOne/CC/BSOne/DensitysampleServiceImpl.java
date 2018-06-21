package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IDensitysampleDao;
import com.tonfun.tools.Model.BSOne.Densitysample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IDensitysampleService;



@Service
public class DensitysampleServiceImpl extends CGenericSysImpl<Densitysample, Long> implements IDensitysampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DensitysampleServiceImpl.class);
  @Autowired
  IDensitysampleDao densitysampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyDensitysample (Long id,Densitysample densitysample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Densitysample predensitysample=densitysampleDao.findById(id);
      predensitysample=densitysample;
      densitysampleDao.update(predensitysample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
