package com.tonfun.tools.controller.autoController.BSOne;
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
import com.tonfun.tools.Model.BSOne.Orderstate;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IOrderstateService;

@Controller
@RequestMapping(value="/Orderstate")
public class OrderstateController{
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderstateController.class);
  @Autowired
  IOrderstateService orderstateservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showorderstatePage() {
    return "/Orderstate/orderstate";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllOrderstates")
  @ResponseBody
  private List<Orderstate> getAllOrderstates () {
    LOGGER.info("返回所有的数据");
    return orderstateservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllOrderstatesByPagination")
  @ResponseBody
  private Pagination<Orderstate> getAllOrderstatesByPagination (PaginationBuilder<Orderstate> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Orderstate>  orderstates = orderstateservice.queryByPagination(paginationBuilder.build());
    return orderstates;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addOrderstate")
  @ResponseBody
  private ErrorCode addOrderstate(@Valid Orderstate orderstate,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.orderstateservice.save(orderstate);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyOrderstate (Long id,Orderstate orderstate,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.orderstateservice.modifyOrderstate(id,orderstate);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteOrderstate")
  @ResponseBody
  private ErrorCode deleteOrderstate(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.orderstateservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
