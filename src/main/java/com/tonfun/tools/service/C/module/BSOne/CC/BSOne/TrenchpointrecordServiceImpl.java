package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ITrenchpointrecordDao;
import com.tonfun.tools.Model.BSOne.Trenchpointrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITrenchpointrecordService;



@Service
public class TrenchpointrecordServiceImpl extends CGenericSysImpl<Trenchpointrecord, Long> implements ITrenchpointrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TrenchpointrecordServiceImpl.class);
  @Autowired
  ITrenchpointrecordDao trenchpointrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyTrenchpointrecord (Long id,Trenchpointrecord trenchpointrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Trenchpointrecord pretrenchpointrecord=trenchpointrecordDao.findById(id);
      pretrenchpointrecord=trenchpointrecord;
      trenchpointrecordDao.update(pretrenchpointrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
