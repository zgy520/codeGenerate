package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorderhistory;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderhistoryDao;



@Repository
public class ProddeliveryorderhistoryDaoImpl extends BSOneGenericDao<Proddeliveryorderhistory, Long> implements IProddeliveryorderhistoryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderhistoryDaoImpl.class);
}
