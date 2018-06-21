package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentrydetailDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentrydetail;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdgodownentrydetailService;



@Service
public class ProdgodownentrydetailServiceImpl extends CGenericSysImpl<Prodgodownentrydetail, Long> implements IProdgodownentrydetailService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentrydetailServiceImpl.class);
  @Autowired
  IProdgodownentrydetailDao prodgodownentrydetailDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdgodownentrydetail (Long id,Prodgodownentrydetail prodgodownentrydetail) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodgodownentrydetail preprodgodownentrydetail=prodgodownentrydetailDao.findById(id);
      preprodgodownentrydetail=prodgodownentrydetail;
      prodgodownentrydetailDao.update(preprodgodownentrydetail);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
