package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IWaterrecordDao;
import com.tonfun.tools.Model.BSOne.Waterrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IWaterrecordService;



@Service
public class WaterrecordServiceImpl extends CGenericSysImpl<Waterrecord, Long> implements IWaterrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(WaterrecordServiceImpl.class);
  @Autowired
  IWaterrecordDao waterrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyWaterrecord (Long id,Waterrecord waterrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Waterrecord prewaterrecord=waterrecordDao.findById(id);
      prewaterrecord=waterrecord;
      waterrecordDao.update(prewaterrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
