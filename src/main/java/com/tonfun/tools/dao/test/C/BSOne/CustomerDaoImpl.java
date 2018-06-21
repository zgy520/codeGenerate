package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Customer;
import com.tonfun.tools.dao.test.I.BSOne.ICustomerDao;



@Repository
public class CustomerDaoImpl extends BSOneGenericDao<Customer, Long> implements ICustomerDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
}
