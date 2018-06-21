package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IInspectionrecordDao;
import com.tonfun.tools.Model.BSOne.Inspectionrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IInspectionrecordService;



@Service
public class InspectionrecordServiceImpl extends CGenericSysImpl<Inspectionrecord, Long> implements IInspectionrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(InspectionrecordServiceImpl.class);
  @Autowired
  IInspectionrecordDao inspectionrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyInspectionrecord (Long id,Inspectionrecord inspectionrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Inspectionrecord preinspectionrecord=inspectionrecordDao.findById(id);
      preinspectionrecord=inspectionrecord;
      inspectionrecordDao.update(preinspectionrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
