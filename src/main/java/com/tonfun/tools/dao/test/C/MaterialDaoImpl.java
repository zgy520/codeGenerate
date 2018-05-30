package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Material;
import com.tonfun.tools.dao.test.I.IMaterialDao;



@Repository
public class MaterialDaoImpl extends SystemGenericDao<Material, Long> implements IMaterialDao {

}
