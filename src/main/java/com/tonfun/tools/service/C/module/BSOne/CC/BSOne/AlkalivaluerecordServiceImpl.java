package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IAlkalivaluerecordDao;
import com.tonfun.tools.Model.BSOne.Alkalivaluerecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IAlkalivaluerecordService;



@Service
public class AlkalivaluerecordServiceImpl extends CGenericSysImpl<Alkalivaluerecord, Long> implements IAlkalivaluerecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AlkalivaluerecordServiceImpl.class);
  @Autowired
  IAlkalivaluerecordDao alkalivaluerecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyAlkalivaluerecord (Long id,Alkalivaluerecord alkalivaluerecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Alkalivaluerecord prealkalivaluerecord=alkalivaluerecordDao.findById(id);
      prealkalivaluerecord=alkalivaluerecord;
      alkalivaluerecordDao.update(prealkalivaluerecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
