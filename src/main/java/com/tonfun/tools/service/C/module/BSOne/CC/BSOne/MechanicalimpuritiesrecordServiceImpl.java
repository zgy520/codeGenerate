package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMechanicalimpuritiesrecordDao;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiesrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMechanicalimpuritiesrecordService;



@Service
public class MechanicalimpuritiesrecordServiceImpl extends CGenericSysImpl<Mechanicalimpuritiesrecord, Long> implements IMechanicalimpuritiesrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MechanicalimpuritiesrecordServiceImpl.class);
  @Autowired
  IMechanicalimpuritiesrecordDao mechanicalimpuritiesrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMechanicalimpuritiesrecord (Long id,Mechanicalimpuritiesrecord mechanicalimpuritiesrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Mechanicalimpuritiesrecord premechanicalimpuritiesrecord=mechanicalimpuritiesrecordDao.findById(id);
      premechanicalimpuritiesrecord=mechanicalimpuritiesrecord;
      mechanicalimpuritiesrecordDao.update(premechanicalimpuritiesrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
