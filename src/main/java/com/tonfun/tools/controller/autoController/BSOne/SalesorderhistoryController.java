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
import com.tonfun.tools.Model.BSOne.Salesorderhistory;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ISalesorderhistoryService;

@Controller
@RequestMapping(value="/Salesorderhistory")
public class SalesorderhistoryController{
  private static final Logger LOGGER = LoggerFactory.getLogger(SalesorderhistoryController.class);
  @Autowired
  ISalesorderhistoryService salesorderhistoryservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showsalesorderhistoryPage() {
    return "/Salesorderhistory/salesorderhistory";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllSalesorderhistorys")
  @ResponseBody
  private List<Salesorderhistory> getAllSalesorderhistorys () {
    LOGGER.info("返回所有的数据");
    return salesorderhistoryservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllSalesorderhistorysByPagination")
  @ResponseBody
  private Pagination<Salesorderhistory> getAllSalesorderhistorysByPagination (PaginationBuilder<Salesorderhistory> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Salesorderhistory>  salesorderhistorys = salesorderhistoryservice.queryByPagination(paginationBuilder.build());
    return salesorderhistorys;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addSalesorderhistory")
  @ResponseBody
  private ErrorCode addSalesorderhistory(@Valid Salesorderhistory salesorderhistory,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.salesorderhistoryservice.save(salesorderhistory);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifySalesorderhistory (Long id,Salesorderhistory salesorderhistory,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.salesorderhistoryservice.modifySalesorderhistory(id,salesorderhistory);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteSalesorderhistory")
  @ResponseBody
  private ErrorCode deleteSalesorderhistory(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.salesorderhistoryservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
