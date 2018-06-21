package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IDensityrecordDao;
import com.tonfun.tools.Model.BSOne.Densityrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IDensityrecordService;



@Service
public class DensityrecordServiceImpl extends CGenericSysImpl<Densityrecord, Long> implements IDensityrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DensityrecordServiceImpl.class);
  @Autowired
  IDensityrecordDao densityrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyDensityrecord (Long id,Densityrecord densityrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Densityrecord predensityrecord=densityrecordDao.findById(id);
      predensityrecord=densityrecord;
      densityrecordDao.update(predensityrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
