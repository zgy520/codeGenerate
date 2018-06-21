package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Prodspec;
import com.tonfun.tools.dao.test.I.BSOne.IProdspecDao;



@Repository
public class ProdspecDaoImpl extends BSOneGenericDao<Prodspec, Long> implements IProdspecDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdspecDaoImpl.class);
}
