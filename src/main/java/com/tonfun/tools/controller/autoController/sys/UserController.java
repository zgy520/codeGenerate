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
import com.tonfun.tools.Model.sys.User;
import com.tonfun.tools.service.I.module.sys.CI.sys.IUserService;

@Controller
@RequestMapping(value="/User")
public class UserController{
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  @Autowired
  IUserService userservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showuserPage() {
    return "/User/user";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllUsers")
  @ResponseBody
  private List<User> getAllUsers () {
    LOGGER.info("返回所有的数据");
    return userservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllUsersByPagination")
  @ResponseBody
  private Pagination<User> getAllUsersByPagination (PaginationBuilder<User> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<User>  users = userservice.queryByPagination(paginationBuilder.build());
    return users;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addUser")
  @ResponseBody
  private ErrorCode addUser(@Valid User user,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.userservice.save(user);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifyuser")
  @ResponseBody
  public ErrorCode modifyUser (Long id,User user,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.userservice.modifyUser(id,user);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteUser")
  @ResponseBody
  private ErrorCode deleteUser(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.userservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
