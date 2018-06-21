package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderdetailDao;
import com.tonfun.tools.Model.BSOne.Salesorderdetail;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ISalesorderdetailService;



@Service
public class SalesorderdetailServiceImpl extends CGenericSysImpl<Salesorderdetail, Long> implements ISalesorderdetailService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderdetailServiceImpl.class);
  @Autowired
  ISalesorderdetailDao salesorderdetailDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifySalesorderdetail (Long id,Salesorderdetail salesorderdetail) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Salesorderdetail presalesorderdetail=salesorderdetailDao.findById(id);
      presalesorderdetail=salesorderdetail;
      salesorderdetailDao.update(presalesorderdetail);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
