package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Salesorder;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderDao;



@Repository
public class SalesorderDaoImpl extends BSOneGenericDao<Salesorder, Long> implements ISalesorderDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderDaoImpl.class);
}
