package com.tonfun.tools.controller.autoController.sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.dao.persistence.pagination.Pagination;
import com.tonfun.tools.dao.persistence.pagination.Pagination.PaginationBuilder;
import com.tonfun.tools.Model.sys.Log;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILogService;

@Controller
@RequestMapping(value="/Log")
public class LogController{
  private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);
  @Autowired
  ILogService logservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showlogPage() {
    return "/Log/log";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllLogs")
  @ResponseBody
  private List<Log> getAllLogs () {
    LOGGER.info("返回所有的数据");
    return logservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllLogsByPagination")
  @ResponseBody
  private Pagination<Log> getAllLogsByPagination (PaginationBuilder<Log> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Log>  logs = logservice.queryByPagination(paginationBuilder.build());
    return logs;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addLog")
  @ResponseBody
  private ErrorCode addLog(@Valid Log log,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.logservice.save(log);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifylog")
  @ResponseBody
  public ErrorCode modifyLog (Long id,Log log,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.logservice.modifyLog(id,log);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteLog")
  @ResponseBody
  private ErrorCode deleteLog(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.logservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
