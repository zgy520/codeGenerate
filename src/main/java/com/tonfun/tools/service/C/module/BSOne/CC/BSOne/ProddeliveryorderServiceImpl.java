package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorder;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProddeliveryorderService;



@Service
public class ProddeliveryorderServiceImpl extends CGenericSysImpl<Proddeliveryorder, Long> implements IProddeliveryorderService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderServiceImpl.class);
  @Autowired
  IProddeliveryorderDao proddeliveryorderDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProddeliveryorder (Long id,Proddeliveryorder proddeliveryorder) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Proddeliveryorder preproddeliveryorder=proddeliveryorderDao.findById(id);
      preproddeliveryorder=proddeliveryorder;
      proddeliveryorderDao.update(preproddeliveryorder);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
