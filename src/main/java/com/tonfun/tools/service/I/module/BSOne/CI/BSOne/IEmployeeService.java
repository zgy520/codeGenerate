package com.tonfun.tools.service.I.module.BSOne.CI.BSOne;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.BSOne.Employee;
import com.tonfun.tools.Error.ErrorCode;

public interface IEmployeeService extends IGenericSysService<Employee, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyEmployee (Long id,Employee employee);
}
