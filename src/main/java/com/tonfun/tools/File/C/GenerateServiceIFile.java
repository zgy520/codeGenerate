package com.tonfun.tools.File.C;

import java.util.Set;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.xml.XmlParserFactory;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月25日 下午8:18:28
*/
public class GenerateServiceIFile extends GenerateJavaFile {

	public GenerateServiceIFile(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void outputClassAnnotation(Table table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void outputClassName(String tableName) {
		// TODO Auto-generated method stub
		printWriter.println("public interface "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"prefix") +
												this.getCaptureTableName() +
												XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"suffix") +
				" extends IGenericSysService<"+this.getCaptureTableName()+", Long> " +
				"{\r\n");
	}

	@Override
	protected void outputClassContent() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void outputReferencePackgaes() {
		// TODO Auto-generated method stub
		super.outputReferencePackgaes();
		printWriter.println("\r\nimport com.tonfun.tools.service.I.module.sys.IGenericSysService;"
				+ "\r\nimport "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+this.getCaptureTableName()+";\r\n");
	}

}
