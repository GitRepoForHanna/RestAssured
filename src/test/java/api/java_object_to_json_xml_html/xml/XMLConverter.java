package api.java_object_to_json_xml_html.xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;

public class XMLConverter {

    public static Document createNewDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    public static Document insertDocumentIntoDocument(Document parentDocument, Document documentToInsert) {
        Node nodeToInsert = documentToInsert.getDocumentElement();
        Node nodeToImport = parentDocument.importNode(nodeToInsert, true);
        parentDocument.getDocumentElement().appendChild(nodeToImport);
        return parentDocument;
    }

    public static Document joinDocuments(List<Document> documentsToJoin, String groupTitle) throws ParserConfigurationException {
        Document resultDocument = createNewDocument();
        Element root = resultDocument.createElement(groupTitle);
        resultDocument.appendChild(root);
        documentsToJoin.forEach(document -> {
            Node nodeToImport = resultDocument.importNode(document.getDocumentElement(), true);
            root.appendChild(nodeToImport);
        });
        return resultDocument;
    }

    public static Attr createAttribute(Document document, String attrName, String attrValue) {
        Attr attr = document.createAttribute(attrName);
        attr.setValue(attrValue);
        return attr;
    }

    public static Attr createValueAttribute(Document document, String attrValue) {
        return createAttribute(document, "value", attrValue);
    }

    public static Attr createNameAttribute(Document document, String attrValue) {
        return createAttribute(document, "name", attrValue);
    }

    public static void insertChildNodes(Node parentNode, List<Node> childNodes) {
        childNodes.forEach(parentNode::appendChild);
    }

    public static void insertChildNode(Node parentNode, Node childNode) {
        parentNode.appendChild(childNode);
    }

    public static void addAttributesToNode(Node node, List<Attr> attributes) {
        attributes.forEach(attr -> node.getAttributes().setNamedItem(attr));
    }

    public static void addAttributeToNode(Node node, Attr attribute) {
        node.getAttributes().setNamedItem(attribute);
    }

    public static void setTextContentToNode(Node node, String textContent) {
        node.setTextContent(textContent);
    }

    public static String prettyPrint(Document document) throws TransformerException {
        StringWriter sw = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(sw));
        return sw.toString();
    }
}
