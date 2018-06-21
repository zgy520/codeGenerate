package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodmodel;
import com.tonfun.tools.dao.test.I.BSOne.IProdmodelDao;



@Repository
public class ProdmodelDaoImpl extends BSOneGenericDao<Prodmodel, Long> implements IProdmodelDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdmodelDaoImpl.class);
}
