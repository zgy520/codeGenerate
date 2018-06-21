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
import com.tonfun.tools.Model.sys.Button;
import com.tonfun.tools.service.I.module.sys.CI.sys.IButtonService;

@Controller
@RequestMapping(value="/Button")
public class ButtonController{
  private static final Logger LOGGER = LoggerFactory.getLogger(ButtonController.class);
  @Autowired
  IButtonService buttonservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showbuttonPage() {
    return "/Button/button";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllButtons")
  @ResponseBody
  private List<Button> getAllButtons () {
    LOGGER.info("返回所有的数据");
    return buttonservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllButtonsByPagination")
  @ResponseBody
  private Pagination<Button> getAllButtonsByPagination (PaginationBuilder<Button> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Button>  buttons = buttonservice.queryByPagination(paginationBuilder.build());
    return buttons;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addButton")
  @ResponseBody
  private ErrorCode addButton(@Valid Button button,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.buttonservice.save(button);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifybutton")
  @ResponseBody
  public ErrorCode modifyButton (Long id,Button button,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.buttonservice.modifyButton(id,button);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteButton")
  @ResponseBody
  private ErrorCode deleteButton(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.buttonservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
