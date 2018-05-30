package com.tonfun.tools.service.C.module.sys.CC;


import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import com.tonfun.tools.Model.Customer;
import com.tonfun.tools.service.I.module.sys.CI.ICustomerService;



@Service
public class CustomerServiceImpl extends CGenericSysImpl<Customer, Long> implements ICustomerService {

}
