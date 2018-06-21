package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IAlkalivaluesampleDao;
import com.tonfun.tools.Model.BSOne.Alkalivaluesample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IAlkalivaluesampleService;



@Service
public class AlkalivaluesampleServiceImpl extends CGenericSysImpl<Alkalivaluesample, Long> implements IAlkalivaluesampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AlkalivaluesampleServiceImpl.class);
  @Autowired
  IAlkalivaluesampleDao alkalivaluesampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyAlkalivaluesample (Long id,Alkalivaluesample alkalivaluesample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Alkalivaluesample prealkalivaluesample=alkalivaluesampleDao.findById(id);
      prealkalivaluesample=alkalivaluesample;
      alkalivaluesampleDao.update(prealkalivaluesample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
