package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Salesorderhistory;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderhistoryDao;



@Repository
public class SalesorderhistoryDaoImpl extends BSOneGenericDao<Salesorderhistory, Long> implements ISalesorderhistoryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderhistoryDaoImpl.class);
}
