package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodgodownentrydetail;
import com.tonfun.tools.dao.test.I.BSOne.IProdgodownentrydetailDao;



@Repository
public class ProdgodownentrydetailDaoImpl extends BSOneGenericDao<Prodgodownentrydetail, Long> implements IProdgodownentrydetailDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdgodownentrydetailDaoImpl.class);
}
