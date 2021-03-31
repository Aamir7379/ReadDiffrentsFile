package com.readfile;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsar {

	public static void main(String[] args) {
		try {
			 File fXmlFile = new File("D:\\Byzan\\sample_input.XML");
			    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			    Document doc = dBuilder.parse(fXmlFile);
			    doc.getDocumentElement().normalize();

			   // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			    NodeList nList = doc.getElementsByTagName("GrpHdr");
			    System.out.println("----------------------------"+nList.getLength());
			    Node nNode=nList.item(0);
			    Element eElement = (Element) nNode;
			    System.out.println("MsgId ::"+ eElement.getElementsByTagName("MsgId").item(0).getTextContent());
			    System.out.println("CreDtTm ::"+ eElement.getElementsByTagName("CreDtTm").item(0).getTextContent());
			    NodeList nListchild = doc.getElementsByTagName("PmtInf");
			    System.out.println("----------------------------"+nListchild.getLength());
			    
			    for (int temp = 0; temp < nListchild.getLength(); temp++) {
			        Node nNodechild = nListchild.item(temp);
			       // System.out.println("\nCurrent Element :" + nNodechild.getNodeName());
			       
			        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			            Element eElementchild = (Element) nNodechild;
			            
			       
System.out.println(temp+"  PmtInfId : "+ eElementchild.getElementsByTagName("PmtInfId").item(0).getTextContent());	

			        }
			    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
