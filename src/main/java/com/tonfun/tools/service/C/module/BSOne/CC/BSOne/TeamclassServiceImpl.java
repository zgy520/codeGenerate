package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ITeamclassDao;
import com.tonfun.tools.Model.BSOne.Teamclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITeamclassService;



@Service
public class TeamclassServiceImpl extends CGenericSysImpl<Teamclass, Long> implements ITeamclassService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TeamclassServiceImpl.class);
  @Autowired
  ITeamclassDao teamclassDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyTeamclass (Long id,Teamclass teamclass) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Teamclass preteamclass=teamclassDao.findById(id);
      preteamclass=teamclass;
      teamclassDao.update(preteamclass);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
