package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentry;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentryDao;



@Repository
public class ProdgodownentryDaoImpl extends BSOneGenericDao<Prodgodownentry, Long> implements IProdgodownentryDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentryDaoImpl.class);
}
