package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderhistoryDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorderhistory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProddeliveryorderhistoryService;



@Service
public class ProddeliveryorderhistoryServiceImpl extends CGenericSysImpl<Proddeliveryorderhistory, Long> implements IProddeliveryorderhistoryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderhistoryServiceImpl.class);
  @Autowired
  IProddeliveryorderhistoryDao proddeliveryorderhistoryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProddeliveryorderhistory (Long id,Proddeliveryorderhistory proddeliveryorderhistory) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Proddeliveryorderhistory preproddeliveryorderhistory=proddeliveryorderhistoryDao.findById(id);
      preproddeliveryorderhistory=proddeliveryorderhistory;
      proddeliveryorderhistoryDao.update(preproddeliveryorderhistory);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
