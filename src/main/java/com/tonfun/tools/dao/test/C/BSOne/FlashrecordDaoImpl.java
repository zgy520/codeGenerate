package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Flashrecord;
import com.tonfun.tools.dao.test.I.BSOne.IFlashrecordDao;



@Repository
public class FlashrecordDaoImpl extends BSOneGenericDao<Flashrecord, Long> implements IFlashrecordDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(FlashrecordDaoImpl.class);
}
