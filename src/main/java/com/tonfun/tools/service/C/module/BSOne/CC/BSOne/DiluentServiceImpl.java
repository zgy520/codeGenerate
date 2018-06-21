package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IDiluentDao;
import com.tonfun.tools.Model.BSOne.Diluent;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IDiluentService;



@Service
public class DiluentServiceImpl extends CGenericSysImpl<Diluent, Long> implements IDiluentService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DiluentServiceImpl.class);
  @Autowired
  IDiluentDao diluentDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyDiluent (Long id,Diluent diluent) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Diluent prediluent=diluentDao.findById(id);
      prediluent=diluent;
      diluentDao.update(prediluent);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
