package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorderdetail;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderdetailDao;



@Repository
public class ProddeliveryorderdetailDaoImpl extends BSOneGenericDao<Proddeliveryorderdetail, Long> implements IProddeliveryorderdetailDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderdetailDaoImpl.class);
}
