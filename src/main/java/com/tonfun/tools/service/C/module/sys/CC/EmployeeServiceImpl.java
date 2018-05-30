package com.tonfun.tools.service.C.module.sys.CC;


import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import com.tonfun.tools.Model.Employee;
import com.tonfun.tools.service.I.module.sys.CI.IEmployeeService;



@Service
public class EmployeeServiceImpl extends CGenericSysImpl<Employee, Long> implements IEmployeeService {

}
