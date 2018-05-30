package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Godownkeeper;
import com.tonfun.tools.dao.test.I.IGodownkeeperDao;



@Repository
public class GodownkeeperDaoImpl extends SystemGenericDao<Godownkeeper, Long> implements IGodownkeeperDao {

}
