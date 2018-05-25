package com.tonfun.tools.File.C;

import java.util.Set;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.xml.XmlParserFactory;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvert;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月25日 下午8:25:47
*/
public class GenerateServiceImpl extends GenerateJavaFile {

	public GenerateServiceImpl(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava());
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
		String modelName = com.tonfun.tools.helper.Utils.captureName(this.curOperateTable.getTableName());
		printWriter.println("public class "+Utils.captureName(this.curOperateTable.getTableName())+"ServiceImpl" +
				" extends CGenericSysImpl<"+modelName+", Long> " + "implements I"+Utils.captureName(this.curOperateTable.getTableName())+"Service "+
				"{\r\n");
	}

	@Override
	protected void outputClassContent(Table table) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void outputReferencePackgaes() {
		// TODO Auto-generated method stub
		super.outputReferencePackgaes();
		String model = com.tonfun.tools.helper.Utils.captureName(this.curOperateTable.getTableName());
		printWriter.println("\r\n\r\nimport org.springframework.stereotype.Service;\r\n" + 
				"import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;\r\n" + 				
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+model+";\r\n"+
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"packageName")+".I"+model+"Service;\r\n");
		printWriter.println("\r\n");
	}

}
