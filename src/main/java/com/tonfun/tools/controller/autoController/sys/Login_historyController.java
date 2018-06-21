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
import com.tonfun.tools.Model.sys.Login_history;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILogin_historyService;

@Controller
@RequestMapping(value="/Login_history")
public class Login_historyController{
  private static final Logger LOGGER = LoggerFactory.getLogger(Login_historyController.class);
  @Autowired
  ILogin_historyService login_historyservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showlogin_historyPage() {
    return "/Login_history/login_history";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllLogin_historys")
  @ResponseBody
  private List<Login_history> getAllLogin_historys () {
    LOGGER.info("返回所有的数据");
    return login_historyservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllLogin_historysByPagination")
  @ResponseBody
  private Pagination<Login_history> getAllLogin_historysByPagination (PaginationBuilder<Login_history> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Login_history>  login_historys = login_historyservice.queryByPagination(paginationBuilder.build());
    return login_historys;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addLogin_history")
  @ResponseBody
  private ErrorCode addLogin_history(@Valid Login_history login_history,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.login_historyservice.save(login_history);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifylogin_history")
  @ResponseBody
  public ErrorCode modifyLogin_history (Long id,Login_history login_history,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.login_historyservice.modifyLogin_history(id,login_history);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteLogin_history")
  @ResponseBody
  private ErrorCode deleteLogin_history(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.login_historyservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
