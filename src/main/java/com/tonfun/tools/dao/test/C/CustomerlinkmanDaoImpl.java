package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Customerlinkman;
import com.tonfun.tools.dao.test.I.ICustomerlinkmanDao;



@Repository
public class CustomerlinkmanDaoImpl extends SystemGenericDao<Customerlinkman, Long> implements ICustomerlinkmanDao {

}
