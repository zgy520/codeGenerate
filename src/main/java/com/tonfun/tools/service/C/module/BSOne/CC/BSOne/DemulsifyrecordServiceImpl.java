package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IDemulsifyrecordDao;
import com.tonfun.tools.Model.BSOne.Demulsifyrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IDemulsifyrecordService;



@Service
public class DemulsifyrecordServiceImpl extends CGenericSysImpl<Demulsifyrecord, Long> implements IDemulsifyrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DemulsifyrecordServiceImpl.class);
  @Autowired
  IDemulsifyrecordDao demulsifyrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyDemulsifyrecord (Long id,Demulsifyrecord demulsifyrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Demulsifyrecord predemulsifyrecord=demulsifyrecordDao.findById(id);
      predemulsifyrecord=demulsifyrecord;
      demulsifyrecordDao.update(predemulsifyrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
