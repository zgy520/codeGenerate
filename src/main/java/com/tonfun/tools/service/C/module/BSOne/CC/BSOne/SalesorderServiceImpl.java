package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderDao;
import com.tonfun.tools.Model.BSOne.Salesorder;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ISalesorderService;



@Service
public class SalesorderServiceImpl extends CGenericSysImpl<Salesorder, Long> implements ISalesorderService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderServiceImpl.class);
  @Autowired
  ISalesorderDao salesorderDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifySalesorder (Long id,Salesorder salesorder) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Salesorder presalesorder=salesorderDao.findById(id);
      presalesorder=salesorder;
      salesorderDao.update(presalesorder);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
