package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdspecDao;
import com.tonfun.tools.Model.BSOne.Prodspec;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdspecService;



@Service
public class ProdspecServiceImpl extends CGenericSysImpl<Prodspec, Long> implements IProdspecService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdspecServiceImpl.class);
  @Autowired
  IProdspecDao prodspecDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdspec (Long id,Prodspec prodspec) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodspec preprodspec=prodspecDao.findById(id);
      preprodspec=prodspec;
      prodspecDao.update(preprodspec);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
