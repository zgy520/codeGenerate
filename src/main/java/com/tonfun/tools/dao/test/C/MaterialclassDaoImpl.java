package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Materialclass;
import com.tonfun.tools.dao.test.I.IMaterialclassDao;



@Repository
public class MaterialclassDaoImpl extends SystemGenericDao<Materialclass, Long> implements IMaterialclassDao {

}
