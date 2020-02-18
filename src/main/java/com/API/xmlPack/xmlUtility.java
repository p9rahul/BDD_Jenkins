package com.API.xmlPack;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class xmlUtility {

	public Object[] compiledXpath(String pxpath) {
		String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\API\\xmlPack\\responseXmlTemplate.xml";

		Document document = null;
		File xmlFilePath = new File(filePath);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = dbFactory.newDocumentBuilder();
			document = documentBuilder.parse(xmlFilePath);
		} catch (Exception e) {
			e.getMessage();
		}

		document.getDocumentElement().normalize();
		NodeList nodelist = null;
		XPath xpath = null;
		try {
			xpath = XPathFactory.newInstance().newXPath();
			nodelist = (NodeList) xpath.compile(pxpath).evaluate(document, XPathConstants.NODESET);
		} catch (Exception e) {
			e.getMessage();
		}

		Object[] obj = new Object[2];
		obj[0] = xpath;
		obj[1] = nodelist;

		return obj;
	}

	/*
	 * <product id="p1"> <name>Apple</name> <price>14</price> </product>
	 * 
	 * //product [1]@name
	 */
	public String getNodeValue(String tag) {

		String[] arr = null;
		if (tag.contains("@"))
			arr = tag.split("@");

		String pXpath = arr[0];
		String cXpath = arr[1];

		String attributeValue = null;

		Object[] obj = compiledXpath(pXpath);
		XPath xpath = (XPath) obj[0];
		NodeList nodeList = (NodeList) obj[1];

		try {
			attributeValue = ((XPath) xpath).compile(cXpath).evaluate(nodeList.item(0));
		} catch (Exception e) {
			e.getMessage();
		}
		return attributeValue;
	}

	/*
	 * <product id="p1" state="KA" city="Bangalore"> call -> //product@state
	 * Return-> state="KA"
	 */
	public String getNodeAttributeValue(String tag) {

		String[] arr = null;
		if (tag.contains("@"))
			arr = tag.split("@");

		String pXpath = arr[0];
		String cXpath = arr[1];

		String attributeValue = null;

		Object[] obj = compiledXpath(pXpath);
//		XPath xpath = (XPath) obj[0];
		NodeList nodeList = (NodeList) obj[1];

		try {
			attributeValue = nodeList.item(0).getAttributes().getNamedItem(cXpath).toString();
		} catch (Exception e) {
			e.getMessage();
		}
		return attributeValue;
	}

	/*
	 * <product id="p1" state="KA" city="Bangalore"> call -> //product[1] Return->
	 * {city=Bangalore, id=p1, state=KA}
	 */
	public HashMap<String, String> getNodeAttributesValue_All(String tag) {

		Object[] obj = compiledXpath(tag);
//		XPath xpath = (XPath) obj[0];
		NodeList nodeList = (NodeList) obj[1];

		HashMap<String, String> attributeMap = new HashMap<String, String>();

		try {
			int nodeAttributesLength = nodeList.item(0).getAttributes().getLength();
//		 System.out.println(nodeAttributesLength);
			for (int i = 0; i < nodeAttributesLength; i++) {
				attributeMap.put(nodeList.item(0).getAttributes().item(i).getNodeName(),
						nodeList.item(0).getAttributes().item(i).getNodeValue());
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return attributeMap;
	}

	public static void main(String[] args) {

		xmlUtility xmlutil = new xmlUtility();
		System.out.println(xmlutil.getNodeValue("//product [1]@name"));
		System.out.println(xmlutil.getNodeAttributeValue("//product@state"));
		System.out.println(xmlutil.getNodeAttributesValue_All("//product[1]"));

	}
}
