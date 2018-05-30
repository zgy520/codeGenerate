package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Customer;
import com.tonfun.tools.dao.test.I.ICustomerDao;



@Repository
public class CustomerDaoImpl extends SystemGenericDao<Customer, Long> implements ICustomerDao {

}
