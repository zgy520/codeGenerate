package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IAnalysisreportclassDao;
import com.tonfun.tools.Model.BSOne.Analysisreportclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IAnalysisreportclassService;



@Service
public class AnalysisreportclassServiceImpl extends CGenericSysImpl<Analysisreportclass, Long> implements IAnalysisreportclassService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AnalysisreportclassServiceImpl.class);
  @Autowired
  IAnalysisreportclassDao analysisreportclassDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyAnalysisreportclass (Long id,Analysisreportclass analysisreportclass) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Analysisreportclass preanalysisreportclass=analysisreportclassDao.findById(id);
      preanalysisreportclass=analysisreportclass;
      analysisreportclassDao.update(preanalysisreportclass);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
