package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ICustomerDao;
import com.tonfun.tools.Model.BSOne.Customer;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ICustomerService;



@Service
public class CustomerServiceImpl extends CGenericSysImpl<Customer, Long> implements ICustomerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
  @Autowired
  ICustomerDao customerDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyCustomer (Long id,Customer customer) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Customer precustomer=customerDao.findById(id);
      precustomer=customer;
      customerDao.update(precustomer);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
