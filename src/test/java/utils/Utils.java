package utils;

import java.io.File;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String randomText(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static int randomInt(int min, int max) {
		Random r = new Random();

		return r.nextInt((max - min) + 1) + min;
	}

	public static String getUsername() {
		return Utils.parseXml("username");
	}

	public static String getPassword() {
		return Utils.parseXml("password");
	}

	public static String getUrl() {
		return Utils.parseXml("url");
	}

	public static String parseXml(String tag) {
		try {

			File file = new File("config\\config.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("config");  
			Node node = nodeList.item(0);  
			
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
				Element eElement = (Element) node;  
				return eElement.getElementsByTagName(tag).item(0).getTextContent();  
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
