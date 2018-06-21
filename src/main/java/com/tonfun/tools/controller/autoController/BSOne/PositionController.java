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
import com.tonfun.tools.Model.BSOne.Position;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IPositionService;

@Controller
@RequestMapping(value="/Position")
public class PositionController{
  private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);
  @Autowired
  IPositionService positionservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showpositionPage() {
    return "/Position/position";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllPositions")
  @ResponseBody
  private List<Position> getAllPositions () {
    LOGGER.info("返回所有的数据");
    return positionservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllPositionsByPagination")
  @ResponseBody
  private Pagination<Position> getAllPositionsByPagination (PaginationBuilder<Position> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Position>  positions = positionservice.queryByPagination(paginationBuilder.build());
    return positions;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addPosition")
  @ResponseBody
  private ErrorCode addPosition(@Valid Position position,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.positionservice.save(position);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyPosition (Long id,Position position,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.positionservice.modifyPosition(id,position);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deletePosition")
  @ResponseBody
  private ErrorCode deletePosition(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.positionservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
