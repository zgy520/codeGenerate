package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Orderstate;
import com.tonfun.tools.dao.test.I.BSOne.IOrderstateDao;



@Repository
public class OrderstateDaoImpl extends BSOneGenericDao<Orderstate, Long> implements IOrderstateDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderstateDaoImpl.class);
}
