package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdbrandDao;
import com.tonfun.tools.Model.BSOne.Prodbrand;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdbrandService;



@Service
public class ProdbrandServiceImpl extends CGenericSysImpl<Prodbrand, Long> implements IProdbrandService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdbrandServiceImpl.class);
  @Autowired
  IProdbrandDao prodbrandDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdbrand (Long id,Prodbrand prodbrand) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodbrand preprodbrand=prodbrandDao.findById(id);
      preprodbrand=prodbrand;
      prodbrandDao.update(preprodbrand);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
