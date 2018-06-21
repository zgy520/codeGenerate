package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Foamitem;
import com.tonfun.tools.dao.test.I.BSOne.IFoamitemDao;



@Repository
public class FoamitemDaoImpl extends BSOneGenericDao<Foamitem, Long> implements IFoamitemDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(FoamitemDaoImpl.class);
}
