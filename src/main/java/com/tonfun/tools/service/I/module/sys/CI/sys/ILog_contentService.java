package com.tonfun.tools.service.I.module.sys.CI.sys;

import com.tonfun.tools.service.I.module.sys.IGenericSysService;
import com.tonfun.tools.Model.sys.Log_content;
import com.tonfun.tools.Error.ErrorCode;

public interface ILog_contentService extends IGenericSysService<Log_content, Long> {
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyLog_content (Long id,Log_content log_content);
}
