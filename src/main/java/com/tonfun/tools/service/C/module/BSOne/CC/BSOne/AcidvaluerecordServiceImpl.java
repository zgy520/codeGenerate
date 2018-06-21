package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IAcidvaluerecordDao;
import com.tonfun.tools.Model.BSOne.Acidvaluerecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IAcidvaluerecordService;



@Service
public class AcidvaluerecordServiceImpl extends CGenericSysImpl<Acidvaluerecord, Long> implements IAcidvaluerecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcidvaluerecordServiceImpl.class);
  @Autowired
  IAcidvaluerecordDao acidvaluerecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyAcidvaluerecord (Long id,Acidvaluerecord acidvaluerecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Acidvaluerecord preacidvaluerecord=acidvaluerecordDao.findById(id);
      preacidvaluerecord=acidvaluerecord;
      acidvaluerecordDao.update(preacidvaluerecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
