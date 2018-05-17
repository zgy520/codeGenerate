package com.tonfun.tools.dao.test;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.model.Employee;





@Repository
public class EmployeeDao extends SystemGenericDao<Employee, Long> {
}
