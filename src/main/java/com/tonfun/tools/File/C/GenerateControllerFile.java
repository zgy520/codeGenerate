package com.tonfun.tools.File.C;

import java.util.Set;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.method.GenericMethodOuput;
import com.tonfun.tools.helper.method.MethodInfo;
import com.tonfun.tools.helper.xml.XmlParserFactory;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月5日 下午10:30:13
*/
public class GenerateControllerFile extends GenerateJavaFile {

	private String serviceImpl;
	public GenerateControllerFile(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava(),FileGeneratorType.Controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void outputClassAnnotation(Table table) {
		// TODO Auto-generated method stub
		this.printWriter.println("@Controller");
		//产生该控制器所对应的请求的总的route
		this.printWriter.println("@RequestMapping(value=\"/"+this.getCaptureTableName()+"\")");
	}

	@Override
	protected void outputClassName(String tableName) {
		// TODO Auto-generated method stub
		String modelName = this.getCaptureTableName();
		this.setClassName(modelName+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Controller,"suffix"));
		printWriter.println("public class "+this.getClassName()+"{");
	}

	@Override
	protected void outputClassContent() {
		// TODO Auto-generated method stub
		super.outputClassContent();
		GenericMethodOuput methodOuput = new GenericMethodOuput(this.printWriter);
		
		// 产生该类所对应的service类
		relateServiceInterface();
		// 0.返回该控制器所对应的jsp页面
		methodOuput.setMethodInfo(this.jspPage());
		methodOuput.outputMethod();
		//jspPage();
		// 1.产生getAll方法
		methodOuput.setMethodInfo(this.createGetAllMethod());
		methodOuput.outputMethod();
		// 1.5 产生getPagination方法
		methodOuput.setMethodInfo(this.createGetAllByPaginationMethod());
		methodOuput.outputMethod();
		// 2.产生add方法
		methodOuput.setMethodInfo(this.createAddEntityMethod());
		methodOuput.outputMethod();
		// 3.产生update方法		
		this.getMethodFactory().outputMethodContent();
		// 4.产生delete方法
		methodOuput.setMethodInfo(this.createDeleteMethod());
		methodOuput.outputMethod();
	}
	@Override
	protected void outputReferencePackgaes() {
		// TODO Auto-generated method stub
		super.outputReferencePackgaes();
		this.printWriter.println("import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\r\n" + 
				"import org.springframework.stereotype.Controller;\r\n" + 
				"import org.springframework.web.bind.annotation.ResponseBody;\r\n" + 
				"import java.util.List;\r\n"+
				"import org.springframework.validation.BindingResult;\r\n"+
				"import javax.validation.Valid;\r\n"+
				"import com.tonfun.tools.Error.DefaultErrorCode;\r\n"+
				"import com.tonfun.tools.Error.ErrCode;\r\n"+
				"import com.tonfun.tools.Error.ErrorCode;\r\n"+
				"import com.tonfun.tools.dao.persistence.pagination.Pagination;\r\n"+
				"import com.tonfun.tools.dao.persistence.pagination.Pagination.PaginationBuilder;\r\n"+				
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName") + "." + this.getCaptureTableName() + ";"
				+ "\r\n"+
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"packageName")+"."+
				  XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"prefix")+
				  this.getCaptureTableName()+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"suffix")+";\r\n");
	}
	/**
	 * 该控制器所用到的所有的service类
	 */
	private void relateServiceInterface() {
		this.printWriter.println("  @Autowired");
		this.serviceImpl = XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"prefix") +
				this.getCaptureTableName() +
				XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"suffix");
		
		this.printWriter.println("  "+this.serviceImpl+" "+this.getTableName()+"service;\r\n");
	}
	/**
	 * 该控制器所对应的jps页面
	 */
	private MethodInfo jspPage() {
		MethodInfo methodInfo = new MethodInfo("private ", "String ", "show"+this.getTableName()+"Page", false);
		methodInfo.setMethodComment("返回对应的jsp页面的路径");
		String[] methodAnnotations = {"@RequestMapping(\"/\")"};
		methodInfo.setMethodAnnotations(methodAnnotations);
		methodInfo.setMethodContent(new StringBuilder().append("    return \"/"+this.getCaptureTableName()+"/"+this.getTableName()+"\";"));
		return methodInfo;
	}
	/**
	 * 产生GetAll方法
	 */
	private MethodInfo createGetAllMethod() {
		MethodInfo methodInfo = new MethodInfo("private ", "List<"+this.getCaptureTableName()+"> ", "getAll"+this.getCaptureTableName()+"s ", false);
		methodInfo.setMethodComment("返回所有的数据");
		String[] methodAnnotations = {"@RequestMapping(\"/getAll"+this.getCaptureTableName()+"s\")","@ResponseBody"};
		methodInfo.setMethodAnnotations(methodAnnotations);
		methodInfo.setMethodContent(new StringBuilder().append("    LOGGER.info(\"返回所有的数据\");").append("\r\n").append("    return "+this.getTableName()+"service.findAll();"));
		return methodInfo;
	}
	/**
	 * 根据分页获相应页的数据
	 * @return
	 */
	private MethodInfo createGetAllByPaginationMethod() {
		MethodInfo methodInfo = new MethodInfo("private ", "Pagination<"+this.getCaptureTableName()+"> ", "getAll"+this.getCaptureTableName()+"sByPagination ", false);
		methodInfo.setMethodComment("根据分页信息获取数据");
		String[] methodAnnotations = {"@RequestMapping(\"/getAll"+this.getCaptureTableName()+"sByPagination\")","@ResponseBody"};
		methodInfo.setMethodAnnotations(methodAnnotations);
		String[] argsTypesList = {"PaginationBuilder<"+this.getCaptureTableName()+">"};
		methodInfo.setArgsTypesList(argsTypesList);
		String[] argsValuesList = {"paginationBuilder"};
		methodInfo.setArgsList(argsValuesList);
		methodInfo.setMethodContent(new StringBuilder().append("    LOGGER.info(\"根据分页信息返回相应的数据\");").append("\r\n")
					.append("    Pagination<"+this.getCaptureTableName()+">  "+this.getCaptureTableName().toLowerCase()+"s = " + this.getTableName()+"service.queryByPagination(paginationBuilder.build());")
					.append("\r\n").append("    return "+this.getCaptureTableName().toLowerCase()+"s;"));
		return methodInfo;
	}
	/**
	 * 创建新增实体的方法
	 * @return
	 */
	private MethodInfo createAddEntityMethod() {
		MethodInfo addEntityMethodInfo = new MethodInfo("private ", "ErrorCode ", "add"+this.getCaptureTableName(), false);
		addEntityMethodInfo.setMethodComment("新增数据");
		String[] methodAnnotations = {"@RequestMapping(\"/add"+this.getCaptureTableName()+"\")","@ResponseBody"};
		String[] methodTypes = {"@Valid "+this.getCaptureTableName(),"BindingResult"};
		String[] methodValues = {this.getCaptureTableName().toLowerCase(),"bindingResult"};
		addEntityMethodInfo.setMethodAnnotations(methodAnnotations);
		addEntityMethodInfo.setArgsTypesList(methodTypes);
		addEntityMethodInfo.setArgsList(methodValues);
		addEntityMethodInfo.setMethodContent(new StringBuilder().
							append("    LOGGER.info(\"新增数据\");").append("\r\n").
							append("    DefaultErrorCode errorCode = new DefaultErrorCode();")
							.append("\r\n")
							.append("    if (bindingResult.hasErrors()) {").append("\r\n")
							.append("      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);")
							.append("\r\n")
							.append("      errorCode.setErrMsg(\"验证失败\"+bindingResult.getAllErrors());")
							.append("\r\n")
							.append("    }else {")
							.append("\r\n")
							.append("      this."+this.getTableName()+"service.save("+this.getCaptureTableName().toLowerCase()+");")
							.append("\r\n").append("    }")						
							.append("\r\n    return errorCode;"));
		return addEntityMethodInfo;
	}
	/**
	 * 创建删除实体数据的方法
	 * @return
	 */
	private MethodInfo createDeleteMethod() {
		MethodInfo deletMethodInfo = new MethodInfo("private ", "ErrorCode ", "delete"+this.getCaptureTableName(), false);
		deletMethodInfo.setMethodComment("根据Id删除实体");
		String[] methodAnnotations = {"@RequestMapping(\"/delete"+this.getCaptureTableName()+"\")","@ResponseBody"};
		String[] methodTypes = {"Long"};
		String[] methodValues = {"id"};
		deletMethodInfo.setMethodAnnotations(methodAnnotations);
		deletMethodInfo.setArgsTypesList(methodTypes);
		deletMethodInfo.setArgsList(methodValues);
		deletMethodInfo.setMethodContent(new StringBuilder()
						.append("    LOGGER.info(\"删除id为\"+id+\"对应的实体数据\");")
						.append("\r\n")
						.append("    DefaultErrorCode errorCode = new DefaultErrorCode();")
						.append("\r\n")
						.append("    try {")
						.append("\r\n")
						.append("      this."+this.getTableName()+"service.deleteById(id);")
						.append("\r\n")
						.append("    }catch (Exception e) {")
						.append("\r\n")
						.append("      errorCode.setErrCode(ErrCode.FAIL);\r\n      errorCode.setErrMsg(\"删除失败，错误提示为:\"+e.getMessage());")
						.append("\r\n")
						.append("    }")
						.append("\r\n    return errorCode;"));
		return deletMethodInfo;
	}
	
	 /*@RequestMapping("/deleteCustomerById")
	  @ResponseBody
	  private ErrorCode deleteCustomer(Long id) {
		  LOGGER.info("删除id为"+id+"的数据");
		  DefaultErrorCode errorCode = new DefaultErrorCode();
		  try {
			  this.customerservice.deleteById(id);
		  }catch (Exception e) {
			// TODO: handle exception
			errorCode.setErrCode(ErrCode.FAIL);
			errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
		}	  
		  return errorCode;
	  }*/

}
