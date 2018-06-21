package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderhistoryDao;
import com.tonfun.tools.Model.BSOne.Salesorderhistory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ISalesorderhistoryService;



@Service
public class SalesorderhistoryServiceImpl extends CGenericSysImpl<Salesorderhistory, Long> implements ISalesorderhistoryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderhistoryServiceImpl.class);
  @Autowired
  ISalesorderhistoryDao salesorderhistoryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifySalesorderhistory (Long id,Salesorderhistory salesorderhistory) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Salesorderhistory presalesorderhistory=salesorderhistoryDao.findById(id);
      presalesorderhistory=salesorderhistory;
      salesorderhistoryDao.update(presalesorderhistory);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
