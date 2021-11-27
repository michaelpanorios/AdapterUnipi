package adapter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DocumentParser {

    public static void main(String[] args) {
        try {

            String home = System.getProperty("user.home");
            File xmlFile = new File(home+"/Downloads/" + "book-order.xml");
            System.out.println("XML input:");
            showXMLfile(xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showXMLfile(File xmlFile) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(xmlFile);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("book");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            System.out.println("\nNode name: " + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Author: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Genre: " + element.getElementsByTagName("genre").item(0).getTextContent());
                System.out.println("Price: " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Publish date: " + element.getElementsByTagName("publish_date").item(0).getTextContent());
                System.out.println("Description: " + element.getElementsByTagName("description").item(0).getTextContent());
            }
        }
    }



}
