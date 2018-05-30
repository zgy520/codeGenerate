package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Position;
import com.tonfun.tools.dao.test.I.IPositionDao;



@Repository
public class PositionDaoImpl extends SystemGenericDao<Position, Long> implements IPositionDao {

}
