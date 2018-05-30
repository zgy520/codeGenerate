package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Densitysample;
import com.tonfun.tools.dao.test.I.IDensitysampleDao;



@Repository
public class DensitysampleDaoImpl extends SystemGenericDao<Densitysample, Long> implements IDensitysampleDao {

}
