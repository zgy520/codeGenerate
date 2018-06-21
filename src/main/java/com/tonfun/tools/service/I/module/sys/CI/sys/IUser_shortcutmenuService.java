package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.User_shortcutmenu;
import com.tonfun.tools.Error.ErrorCode;

public interface IUser_shortcutmenuService extends IGenericSysService<User_shortcutmenu, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyUser_shortcutmenu (Long id,User_shortcutmenu user_shortcutmenu);
}
