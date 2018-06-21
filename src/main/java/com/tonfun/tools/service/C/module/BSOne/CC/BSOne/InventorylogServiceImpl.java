package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IInventorylogDao;
import com.tonfun.tools.Model.BSOne.Inventorylog;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IInventorylogService;



@Service
public class InventorylogServiceImpl extends CGenericSysImpl<Inventorylog, Long> implements IInventorylogService {
  private static final Logger LOGGER = LoggerFactory.getLogger(InventorylogServiceImpl.class);
  @Autowired
  IInventorylogDao inventorylogDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyInventorylog (Long id,Inventorylog inventorylog) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Inventorylog preinventorylog=inventorylogDao.findById(id);
      preinventorylog=inventorylog;
      inventorylogDao.update(preinventorylog);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
