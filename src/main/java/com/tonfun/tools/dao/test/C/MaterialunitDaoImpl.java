package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Materialunit;
import com.tonfun.tools.dao.test.I.IMaterialunitDao;



@Repository
public class MaterialunitDaoImpl extends SystemGenericDao<Materialunit, Long> implements IMaterialunitDao {

}
