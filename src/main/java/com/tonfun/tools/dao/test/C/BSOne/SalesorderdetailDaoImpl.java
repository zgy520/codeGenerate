package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Salesorderdetail;
import com.tonfun.tools.dao.test.I.BSOne.ISalesorderdetailDao;



@Repository
public class SalesorderdetailDaoImpl extends BSOneGenericDao<Salesorderdetail, Long> implements ISalesorderdetailDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderdetailDaoImpl.class);
}
