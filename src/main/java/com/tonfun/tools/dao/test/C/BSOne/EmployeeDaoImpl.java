package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Employee;
import com.tonfun.tools.dao.test.I.BSOne.IEmployeeDao;



@Repository
public class EmployeeDaoImpl extends BSOneGenericDao<Employee, Long> implements IEmployeeDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);
}
