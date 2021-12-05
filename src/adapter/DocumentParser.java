package adapter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class DocumentParser {

    public static void main(String[] args) {
        try {
            String home = System.getProperty("user.home");
            File xmlFile = new File(home+"/Downloads/" + "book-order.xml");
            System.out.println("XML input:");
            /** Method which gets the XML file and setting the values to objects */
            showXMLfile(xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showXMLfile(File xmlFile) throws ParserConfigurationException, IOException, SAXException, ParseException {
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

        /** User input validations start */
        FieldsValidation validation = new FieldsValidation();
        validation.populateValidations(elementsBookOrder);
        /** Final XML output file */
        showFinalXMLFile(elementsBookOrder);
    }

    private static void showFinalXMLFile(ElementsBookOrder elementsBookOrder) {
        String home = System.getProperty("user.home");
        final String path = home+"/Downloads/" + "book-order-final.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            /** Book element */
            Element root = document.createElement("book");
            document.appendChild(root);

            /** Author element */
            Element author = document.createElement("author");
            author.appendChild(document.createTextNode(elementsBookOrder.getAuthor()));
            root.appendChild(author);

            /** Title element */
            Element title = document.createElement("title");
            title.appendChild(document.createTextNode(elementsBookOrder.getTitle()));
            root.appendChild(title);

            /** Genre element */
            Element genre = document.createElement("genre");
            genre.appendChild(document.createTextNode(elementsBookOrder.getGenre()));
            root.appendChild(genre);

            /** Price element */
            Element price = document.createElement("price");
            price.appendChild(document.createTextNode(elementsBookOrder.getPrice()));
            root.appendChild(price);

            /** Publish date element */
            Element publish_date = document.createElement("publish_date");
            publish_date.appendChild(document.createTextNode(elementsBookOrder.getPublish_date()));
            root.appendChild(publish_date);

            /** Description element */
            Element description = document.createElement("description");
            description.appendChild(document.createTextNode(elementsBookOrder.getDescription()));
            root.appendChild(description);

            /** Create the xml file and transform the DOM Object to an XML File */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(path));

            transformer.transform(domSource, streamResult);


        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }

}
