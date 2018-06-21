package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdmodelDao;
import com.tonfun.tools.Model.BSOne.Prodmodel;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdmodelService;



@Service
public class ProdmodelServiceImpl extends CGenericSysImpl<Prodmodel, Long> implements IProdmodelService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdmodelServiceImpl.class);
  @Autowired
  IProdmodelDao prodmodelDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdmodel (Long id,Prodmodel prodmodel) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Prodmodel preprodmodel=prodmodelDao.findById(id);
      preprodmodel=prodmodel;
      prodmodelDao.update(preprodmodel);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
