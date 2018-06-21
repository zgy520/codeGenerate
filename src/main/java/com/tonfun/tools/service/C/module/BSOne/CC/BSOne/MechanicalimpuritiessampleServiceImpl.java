package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMechanicalimpuritiessampleDao;
import com.tonfun.tools.Model.BSOne.Mechanicalimpuritiessample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMechanicalimpuritiessampleService;



@Service
public class MechanicalimpuritiessampleServiceImpl extends CGenericSysImpl<Mechanicalimpuritiessample, Long> implements IMechanicalimpuritiessampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MechanicalimpuritiessampleServiceImpl.class);
  @Autowired
  IMechanicalimpuritiessampleDao mechanicalimpuritiessampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMechanicalimpuritiessample (Long id,Mechanicalimpuritiessample mechanicalimpuritiessample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Mechanicalimpuritiessample premechanicalimpuritiessample=mechanicalimpuritiessampleDao.findById(id);
      premechanicalimpuritiessample=mechanicalimpuritiessample;
      mechanicalimpuritiessampleDao.update(premechanicalimpuritiessample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
