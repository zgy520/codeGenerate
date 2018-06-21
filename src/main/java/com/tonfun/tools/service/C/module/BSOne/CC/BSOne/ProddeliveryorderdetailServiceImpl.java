package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IProddeliveryorderdetailDao;
import com.tonfun.tools.Model.BSOne.Proddeliveryorderdetail;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProddeliveryorderdetailService;



@Service
public class ProddeliveryorderdetailServiceImpl extends CGenericSysImpl<Proddeliveryorderdetail, Long> implements IProddeliveryorderdetailService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProddeliveryorderdetailServiceImpl.class);
  @Autowired
  IProddeliveryorderdetailDao proddeliveryorderdetailDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyProddeliveryorderdetail (Long id,Proddeliveryorderdetail proddeliveryorderdetail) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Proddeliveryorderdetail preproddeliveryorderdetail=proddeliveryorderdetailDao.findById(id);
      preproddeliveryorderdetail=proddeliveryorderdetail;
      proddeliveryorderdetailDao.update(preproddeliveryorderdetail);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
