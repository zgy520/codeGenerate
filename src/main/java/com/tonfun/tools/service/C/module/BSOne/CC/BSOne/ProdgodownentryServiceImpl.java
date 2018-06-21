package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentryDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentry;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdgodownentryService;



@Service
public class ProdgodownentryServiceImpl extends CGenericSysImpl<Prodgodownentry, Long> implements IProdgodownentryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentryServiceImpl.class);
  @Autowired
  IProdgodownentryDao prodgodownentryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdgodownentry (Long id,Prodgodownentry prodgodownentry) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodgodownentry preprodgodownentry=prodgodownentryDao.findById(id);
      preprodgodownentry=prodgodownentry;
      prodgodownentryDao.update(preprodgodownentry);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
