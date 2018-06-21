package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorder;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderDao;



@Repository
public class ProddeliveryorderDaoImpl extends BSOneGenericDao<Proddeliveryorder, Long> implements IProddeliveryorderDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderDaoImpl.class);
}
