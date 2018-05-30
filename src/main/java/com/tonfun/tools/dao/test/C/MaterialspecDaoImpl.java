package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Materialspec;
import com.tonfun.tools.dao.test.I.IMaterialspecDao;



@Repository
public class MaterialspecDaoImpl extends SystemGenericDao<Materialspec, Long> implements IMaterialspecDao {

}
