package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentryhistory;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentryhistoryDao;



@Repository
public class ProdgodownentryhistoryDaoImpl extends BSOneGenericDao<Prodgodownentryhistory, Long> implements IProdgodownentryhistoryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentryhistoryDaoImpl.class);
}
