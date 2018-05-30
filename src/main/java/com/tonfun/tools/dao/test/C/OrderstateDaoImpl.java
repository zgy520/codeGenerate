package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Orderstate;
import com.tonfun.tools.dao.test.I.IOrderstateDao;



@Repository
public class OrderstateDaoImpl extends SystemGenericDao<Orderstate, Long> implements IOrderstateDao {

}