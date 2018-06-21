package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IAcidvaluesampleDao;
import com.tonfun.tools.Model.BSOne.Acidvaluesample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IAcidvaluesampleService;



@Service
public class AcidvaluesampleServiceImpl extends CGenericSysImpl<Acidvaluesample, Long> implements IAcidvaluesampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcidvaluesampleServiceImpl.class);
  @Autowired
  IAcidvaluesampleDao acidvaluesampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyAcidvaluesample (Long id,Acidvaluesample acidvaluesample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Acidvaluesample preacidvaluesample=acidvaluesampleDao.findById(id);
      preacidvaluesample=acidvaluesample;
      acidvaluesampleDao.update(preacidvaluesample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
