package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IEmployeeDao;
import com.tonfun.tools.Model.BSOne.Employee;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IEmployeeService;



@Service
public class EmployeeServiceImpl extends CGenericSysImpl<Employee, Long> implements IEmployeeService {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
  @Autowired
  IEmployeeDao employeeDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyEmployee (Long id,Employee employee) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Employee preemployee=employeeDao.findById(id);
      preemployee=employee;
      employeeDao.update(preemployee);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
