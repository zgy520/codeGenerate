package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProdunitDao;
import com.tonfun.tools.Model.BSOne.Produnit;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProdunitService;



@Service
public class ProdunitServiceImpl extends CGenericSysImpl<Produnit, Long> implements IProdunitService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProdunitServiceImpl.class);
  @Autowired
  IProdunitDao produnitDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProdunit (Long id,Produnit produnit) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Produnit preprodunit=produnitDao.findById(id);
      preprodunit=produnit;
      produnitDao.update(preprodunit);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
