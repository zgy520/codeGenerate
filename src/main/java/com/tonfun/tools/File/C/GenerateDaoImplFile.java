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
* @version 创建时间：2018年5月24日 下午11:40:17
*/
public class GenerateDaoImplFile extends GenerateJavaFile {

	public GenerateDaoImplFile(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void outputClassAnnotation(Table table) {
		// TODO Auto-generated method stub
		this.printWriter.println("@Repository");	
	}

	@Override
	protected void outputClassName(String tableName) {
		// TODO Auto-generated method stub
		printWriter.println("public class "+Utils.captureName(this.curOperateTable.getTableName())+"DaoImpl" +
				" extends SystemGenericDao<"+Utils.captureName(this.curOperateTable.getTableName())+", Long> " + "implements I"+Utils.captureName(this.curOperateTable.getTableName())+"Dao "+
				"{\r\n");  //产生类名
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
		this.printWriter.println("\r\n\r\nimport org.springframework.stereotype.Repository;\r\n" + 
				"import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;\r\n" + 				
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+model+";\r\n"+
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.DaoInterface,"packageName")+".I"+model+"Dao;\r\n");
		this.printWriter.println("\r\n");
	}

}
