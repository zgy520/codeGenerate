package com.tonfun.tools.dao.test;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.model.Salesorder;





@Repository
public class SalesorderDao extends SystemGenericDao<Salesorder, Long> {
}
