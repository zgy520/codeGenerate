package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialDao;
import com.tonfun.tools.Model.BSOne.Material;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialService;



@Service
public class MaterialServiceImpl extends CGenericSysImpl<Material, Long> implements IMaterialService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialServiceImpl.class);
  @Autowired
  IMaterialDao materialDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMaterial (Long id,Material material) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Material prematerial=materialDao.findById(id);
      prematerial=material;
      materialDao.update(prematerial);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
