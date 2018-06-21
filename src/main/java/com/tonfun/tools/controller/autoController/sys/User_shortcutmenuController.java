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
import com.tonfun.tools.Model.sys.User_shortcutmenu;
import com.tonfun.tools.service.I.module.sys.CI.sys.IUser_shortcutmenuService;

@Controller
@RequestMapping(value="/User_shortcutmenu")
public class User_shortcutmenuController{
  private static final Logger LOGGER = LoggerFactory.getLogger(User_shortcutmenuController.class);
  @Autowired
  IUser_shortcutmenuService user_shortcutmenuservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showuser_shortcutmenuPage() {
    return "/User_shortcutmenu/user_shortcutmenu";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllUser_shortcutmenus")
  @ResponseBody
  private List<User_shortcutmenu> getAllUser_shortcutmenus () {
    LOGGER.info("返回所有的数据");
    return user_shortcutmenuservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllUser_shortcutmenusByPagination")
  @ResponseBody
  private Pagination<User_shortcutmenu> getAllUser_shortcutmenusByPagination (PaginationBuilder<User_shortcutmenu> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<User_shortcutmenu>  user_shortcutmenus = user_shortcutmenuservice.queryByPagination(paginationBuilder.build());
    return user_shortcutmenus;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addUser_shortcutmenu")
  @ResponseBody
  private ErrorCode addUser_shortcutmenu(@Valid User_shortcutmenu user_shortcutmenu,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.user_shortcutmenuservice.save(user_shortcutmenu);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifyuser_shortcutmenu")
  @ResponseBody
  public ErrorCode modifyUser_shortcutmenu (Long id,User_shortcutmenu user_shortcutmenu,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.user_shortcutmenuservice.modifyUser_shortcutmenu(id,user_shortcutmenu);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteUser_shortcutmenu")
  @ResponseBody
  private ErrorCode deleteUser_shortcutmenu(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.user_shortcutmenuservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
