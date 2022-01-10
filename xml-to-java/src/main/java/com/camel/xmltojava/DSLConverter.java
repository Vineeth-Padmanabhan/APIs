package com.camel.xmltojava;

import org.w3c.dom.Node;

public class DSLConverter {
	
	public String convertBeanTag(Node node) {
		String returnValue="";
		if(XmlParser.containsAttribute(node, "method")) {
			returnValue= ".bean(\"" + XmlParser.getAttributeValue(node,"ref") + "\",\""+ XmlParser.getAttributeValue(node,"ref") + "\")";
		}else if(XmlParser.containsAttribute(node, "beanType")) {
			returnValue= ".bean(\"" + XmlParser.getAttributeValue(node,"ref") + "\",\""+ XmlParser.getAttributeValue(node,"beanType") + "\")";
		}else {
			returnValue= ".bean(\"" + XmlParser.getAttributeValue(node,"ref") + "\")";
		}
		return returnValue;
	}

}
