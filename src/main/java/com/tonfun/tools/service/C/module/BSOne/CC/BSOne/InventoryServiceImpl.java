package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IInventoryDao;
import com.tonfun.tools.Model.BSOne.Inventory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IInventoryService;



@Service
public class InventoryServiceImpl extends CGenericSysImpl<Inventory, Long> implements IInventoryService {
  private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);
  @Autowired
  IInventoryDao inventoryDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyInventory (Long id,Inventory inventory) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Inventory preinventory=inventoryDao.findById(id);
      preinventory=inventory;
      inventoryDao.update(preinventory);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
