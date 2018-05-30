package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Materialmodel;
import com.tonfun.tools.dao.test.I.IMaterialmodelDao;



@Repository
public class MaterialmodelDaoImpl extends SystemGenericDao<Materialmodel, Long> implements IMaterialmodelDao {

}
