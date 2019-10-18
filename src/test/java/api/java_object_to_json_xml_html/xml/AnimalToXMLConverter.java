package api.java_object_to_json_xml_html.xml;

import api.java_object_to_json_xml_html.Animal;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Arrays;
import java.util.List;

public class AnimalToXMLConverter {

    public static Document createDocumentStructure(Animal animal) throws ParserConfigurationException {
        Document document = XMLConverter.createNewDocument();
        Element root = document.createElement(animal.getTAG());
        document.appendChild(root);
        Node color = document.createElement("Color");
        Node age = document.createElement("Age");
        Node name = document.createElement("Name");

        Attr colorNodeAttr = XMLConverter.createValueAttribute(document, animal.getColor());
        Attr nameNodeAttr = XMLConverter.createNameAttribute(document, animal.getName());

        XMLConverter.addAttributeToNode(color, colorNodeAttr);
        XMLConverter.setTextContentToNode(age, Integer.toString(animal.getAge()));
        XMLConverter.addAttributeToNode(name, nameNodeAttr);

        XMLConverter.insertChildNodes(root, Arrays.asList(color, age, name));

        return document;
    }

    public static Document createDocumentStructure(List<Animal> animals) throws ParserConfigurationException {
        String rootName = "Animals";
        Document document = XMLConverter.createNewDocument();
        Element root = document.createElement(rootName);
        document.appendChild(root);

        animals.forEach(animal -> {
            try {
                Node childNode = createDocumentStructure(animal).getDocumentElement();
                Node nodeToImport = document.importNode(childNode, true);
                root.appendChild(nodeToImport);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        });

        return document;
    }

}
