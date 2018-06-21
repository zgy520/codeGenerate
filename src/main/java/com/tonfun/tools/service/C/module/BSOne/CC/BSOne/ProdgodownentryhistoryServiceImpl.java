package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentryhistoryDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentryhistory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdgodownentryhistoryService;



@Service
public class ProdgodownentryhistoryServiceImpl extends CGenericSysImpl<Prodgodownentryhistory, Long> implements IProdgodownentryhistoryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentryhistoryServiceImpl.class);
  @Autowired
  IProdgodownentryhistoryDao prodgodownentryhistoryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdgodownentryhistory (Long id,Prodgodownentryhistory prodgodownentryhistory) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodgodownentryhistory preprodgodownentryhistory=prodgodownentryhistoryDao.findById(id);
      preprodgodownentryhistory=prodgodownentryhistory;
      prodgodownentryhistoryDao.update(preprodgodownentryhistory);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
