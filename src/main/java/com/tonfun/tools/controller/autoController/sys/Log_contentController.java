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
import com.tonfun.tools.Model.sys.Log_content;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILog_contentService;

@Controller
@RequestMapping(value="/Log_content")
public class Log_contentController{
  private static final Logger LOGGER = LoggerFactory.getLogger(Log_contentController.class);
  @Autowired
  ILog_contentService log_contentservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showlog_contentPage() {
    return "/Log_content/log_content";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllLog_contents")
  @ResponseBody
  private List<Log_content> getAllLog_contents () {
    LOGGER.info("返回所有的数据");
    return log_contentservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllLog_contentsByPagination")
  @ResponseBody
  private Pagination<Log_content> getAllLog_contentsByPagination (PaginationBuilder<Log_content> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Log_content>  log_contents = log_contentservice.queryByPagination(paginationBuilder.build());
    return log_contents;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addLog_content")
  @ResponseBody
  private ErrorCode addLog_content(@Valid Log_content log_content,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.log_contentservice.save(log_content);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifylog_content")
  @ResponseBody
  public ErrorCode modifyLog_content (Long id,Log_content log_content,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.log_contentservice.modifyLog_content(id,log_content);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteLog_content")
  @ResponseBody
  private ErrorCode deleteLog_content(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.log_contentservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
