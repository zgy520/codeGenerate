package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Materialbrand;
import com.tonfun.tools.dao.test.I.IMaterialbrandDao;



@Repository
public class MaterialbrandDaoImpl extends SystemGenericDao<Materialbrand, Long> implements IMaterialbrandDao {

}
