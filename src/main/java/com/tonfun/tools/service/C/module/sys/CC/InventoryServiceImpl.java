package com.tonfun.tools.service.C.module.sys.CC;


import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import com.tonfun.tools.Model.Inventory;
import com.tonfun.tools.service.I.module.sys.CI.IInventoryService;



@Service
public class InventoryServiceImpl extends CGenericSysImpl<Inventory, Long> implements IInventoryService {

}
