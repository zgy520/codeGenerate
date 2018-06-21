package com.tonfun.tools.File.C;

import java.util.Set;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.xml.XmlParserFactory;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月25日 下午8:25:47
*/
public class GenerateServiceImplFile extends GenerateJavaFile {
	private String daoImpl;
	public GenerateServiceImplFile(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava(),FileGeneratorType.ServiceImpl);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void outputClassAnnotation(Table table) {
		// TODO Auto-generated method stub
		this.printWriter.println("@Service");
	}

	@Override
	protected void outputClassName(String tableName) {
		// TODO Auto-generated method stub		
		String modelName = this.getCaptureTableName();
		this.setClassName(modelName+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceImpl,"suffix"));
		printWriter.println("public class "+ this.getClassName() +
				" extends CGenericSysImpl<"+modelName+", Long> " + "implements "+
				XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"prefix")+
				modelName+
				XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"suffix")+" "+
				"{");
	}

	@Override
	protected void outputClassContent() {
		// TODO Auto-generated method stub
		super.outputClassContent();
		// 输出dao类
		relateDaoInterface();
		this.getMethodFactory().outputMethodContent();
	}
	private void relateDaoInterface() {
		this.printWriter.println("  @Autowired");
		this.daoImpl = XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface,"prefix") +
				this.getCaptureTableName() +
				XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface,"suffix");
		
		this.printWriter.println("  "+this.daoImpl+" "+this.getTableName()+"Dao;\r\n");
	}
	
	@Override
	protected void outputReferencePackgaes() {
		// TODO Auto-generated method stub
		super.outputReferencePackgaes();
		String model = this.getCaptureTableName();
		printWriter.println("\r\n\r\nimport org.springframework.stereotype.Service;\r\n" + 
				"import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;\r\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\r\n" +
				"import com.tonfun.tools.Error.ErrorCode;\r\n" +
				"import com.tonfun.tools.Error.DefaultErrorCode;\r\n" +
				"import com.tonfun.tools.Error.ErrCode;\r\n" +
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface, "packageName")+"."+
						  XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface, "prefix") + model+
						  XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface, "suffix")+";\r\n" +
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+model+";\r\n"+
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"packageName")+"."+
						  XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"prefix")+
						  model+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"suffix")+";\r\n");
		printWriter.println("\r\n");
	}

}
