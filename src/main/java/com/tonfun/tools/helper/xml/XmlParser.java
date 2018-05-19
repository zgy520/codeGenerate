/*
** TONFUN CONFIDENTIAL AND PROPRIETARY.
**
** This source is the sole property of Tonfun CO.,Ltd. Reproduction or Utilization of this source
** in whole or in part is forbidden without the written consent of Tonfun CO.,Ltd.
** 此文件所有权仅归天津同丰信息技术有限公司所有。
** 未经天津同丰信息技术有限公司书面同意，严禁对此文件的全部或部分进行复制或使用。
**
** Tonfun CONFIDENTIAL.
** Copyright 2011-2018 Tonfun Corporation All Rights Reserved.
** 天津同丰信息技术有限公司机密。
** Copyright 2011-2018 天津同丰信息技术有限公司保留所有权利。
**--------------------------------------------------------------------------------------------------
**
**  文件名: XmlParser.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月19日 下午5:51:23
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.helper.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tonfun.tools.File.FileGeneratorType;


/** ========================================================================================
 * @author a4423
 * xml 解析器
 * =======================================================================================*/
public class XmlParser implements IXmlParser {
	private String xmlFileName;  // 需要解析的xml文件
	private File xmlFile;
	public XmlParser(String xmlFileName) {
		this.xmlFileName = xmlFileName;
		xmlFile = new File(xmlFileName);
	}
	/** ========================================================================================
	 * xmlParser: 
	 * @see com.tonfun.tools.helper.xml.IXmlParser#xmlParser()
	 * =======================================================================================*/
	@Override
	public String xmlParser(FileGeneratorType fileGeneratorType) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(this.xmlFile);
			doc.getDocumentElement().normalize();			
			Node node = doc.getElementsByTagName("packageName").item(0); 		
			return parseNode(node,fileGeneratorType);						
		}catch (SAXException | ParserConfigurationException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();			
		}
		return "";
	}
	
	private String parseNode(Node node,FileGeneratorType fileGeneratorType) {	
		String packageName = "";
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element)node;
			packageName = getTagValue(fileGeneratorType.name(), element);
			//System.out.println("mode is:"+getTagValue(fileGeneratorType.name(), element));			
		}
		return packageName;
	}
	/**
	 * ========================================================================================
	 * getTagValue: 
	 * @param tag
	 * @param element
	 * @return
	 * =======================================================================================
	 */
	private String getTagValue(String tag,Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
	}
	
}
