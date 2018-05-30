package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Flashrecord;
import com.tonfun.tools.dao.test.I.IFlashrecordDao;



@Repository
public class FlashrecordDaoImpl extends SystemGenericDao<Flashrecord, Long> implements IFlashrecordDao {

}
