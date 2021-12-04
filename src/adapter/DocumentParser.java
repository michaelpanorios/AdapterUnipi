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
import java.util.ArrayList;
import java.util.List;

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
        Node node = nodeList.item(0);
        ElementsBookOrder elementsBookOrder = new ElementsBookOrder();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            /** Setting the elements of the XML order file */
            elementsBookOrder.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
            elementsBookOrder.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
            elementsBookOrder.setGenre(element.getElementsByTagName("genre").item(0).getTextContent());
            elementsBookOrder.setPrice(element.getElementsByTagName("price").item(0).getTextContent());
            elementsBookOrder.setPublish_date(element.getElementsByTagName("publish_date").item(0).getTextContent());
            elementsBookOrder.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
            System.out.println(elementsBookOrder.toString());
        }
    }

}
