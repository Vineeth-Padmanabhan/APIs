package com.camel.xmltojava;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	
	public void parseXml() throws ParserConfigurationException, SAXException, IOException {
		
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	      Document doc = dbf.newDocumentBuilder().parse("C:\\Vineeth\\Git\\api\\camelinaction\\chapter5\\errorhandler\\src\\test\\resources\\camelinaction\\RouteScopeTest.xml");
	      doc.getDocumentElement().normalize();
	      System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	      if (doc.hasChildNodes()) {
              printNote(doc.getChildNodes());
          }


		
	}
	
	 private static void printNote(NodeList nodeList) {

	      for (int count = 0; count < nodeList.getLength(); count++) {

	          Node tempNode = nodeList.item(count);

	          // make sure it's element node.
	          if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

	              // get node name and value
	              System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
	              System.out.println("Node Value =" + tempNode.getTextContent().trim());

	              if (tempNode.hasAttributes()) {

	                  // get attributes names and values
	                  NamedNodeMap nodeMap = tempNode.getAttributes();
	                  for (int i = 0; i < nodeMap.getLength(); i++) {
	                      Node node = nodeMap.item(i);
	                      System.out.println("attr name : " + node.getNodeName().trim());
	                      System.out.println("attr value : " + node.getNodeValue().trim());
	                  }

	              }

	              if (tempNode.hasChildNodes()) {
	                  // loop again if has child nodes
	                  printNote(tempNode.getChildNodes());
	              }

	              System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

	          }else {
	        	  
	        	  System.out.println("$$$$$$$$$$$$$$$$$$$"+tempNode.getNodeType());
	        	  System.out.println("Node Value23 =" + tempNode.getTextContent().trim());
	        	  
	          }

	      }
	      
	      
	     


}
	 public static boolean containsAttribute(Node node, String attribute){
		 
		 boolean returnValue= false;
		 if (node.hasAttributes()) {

             // get attributes names and values
             NamedNodeMap nodeMap = node.getAttributes();
             for (int i = 0; i < nodeMap.getLength(); i++) {
                 Node attributeNode = nodeMap.item(i);
               if(attribute.equalsIgnoreCase(attributeNode.getNodeName())) {
            	   returnValue = true;
            	   break;
               }
             }

         }
		return false;
   	  
     }
	 
public static String getAttributeValue(Node node, String attribute){
		 
		 String returnValue=null;
		 if (node.hasAttributes()) {

             // get attributes names and values
             NamedNodeMap nodeMap = node.getAttributes();
             for (int i = 0; i < nodeMap.getLength(); i++) {
                 Node attributeNode = nodeMap.item(i);
               if(attribute.equalsIgnoreCase(attributeNode.getNodeName())) {
            	   returnValue = attributeNode.getNodeValue();
            	   break;
               }
             }

         }
		 
		 if(returnValue == null) {
			 throw new IllegalStateException();
			 
		 }
		return returnValue;
   	  
     }

}
