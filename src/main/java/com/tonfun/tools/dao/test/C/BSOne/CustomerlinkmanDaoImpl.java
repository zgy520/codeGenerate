package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Customerlinkman;
import com.tonfun.tools.dao.test.I.BSOne.ICustomerlinkmanDao;



@Repository
public class CustomerlinkmanDaoImpl extends BSOneGenericDao<Customerlinkman, Long> implements ICustomerlinkmanDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerlinkmanDaoImpl.class);
}
