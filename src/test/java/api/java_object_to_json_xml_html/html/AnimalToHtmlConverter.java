package api.java_object_to_json_xml_html.html;

import api.java_object_to_json_xml_html.Animal;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

import static api.java_object_to_json_xml_html.HTMLTags.*;

public class AnimalToHtmlConverter {

    public static void addTitleToElement(Element element, String title) {
        Element elementTitle = new Element(H2.getTag());
        elementTitle.text(title);
        element.append(elementTitle.toString());
    }

    public static Element createAnimalDiv(Animal animal) {
        Element parentDiv = new Element(DIV.getTag());
        addTitleToElement(parentDiv, animal.getTAG());
        Element colorDiv = createPropertyDiv("Color", animal.getColor());
        Element ageDiv = createPropertyDiv("Age", Integer.toString(animal.getAge()));
        Element nameDiv = createNameDiv(animal.getName());
        parentDiv.append(colorDiv.toString());
        parentDiv.append(ageDiv.toString());
        parentDiv.append(nameDiv.toString());
        return parentDiv;
    }

    public static Element createPropertyDiv(String propertyName, String propertyValue) {
        Element propertyDiv = new Element(DIV.getTag());
        Attribute attrName = HtmlConverter.createAttribute("name", propertyName);
        Attribute attrValue = HtmlConverter.createAttribute("value", propertyValue);
        HtmlConverter.addAttributeToElement(propertyDiv, attrName);
        HtmlConverter.addAttributeToElement(propertyDiv, attrValue);
        return propertyDiv;
    }

    public static Element createNameDiv(String name) {
        Element table = new Element(TABLE.getTag());
        Element tableRow = new Element(TR.getTag());
        Element nameCell = new Element(TD.getTag());
        Element valueCell = new Element(TD.getTag());
        nameCell.text("Name");
        valueCell.text(name);
        tableRow.append(nameCell.toString());
        tableRow.append(valueCell.toString());
        table.append(tableRow.toString());
        Attribute border = HtmlConverter.createAttribute("border", "2");
        table.attributes().put(border);
        return table;
    }

    public static Document createDocumentStructure(Animal animal) {
        Document document = HtmlConverter.createNewDocument("My Document");
        Element body = document.body();
        Element parentDiv = createAnimalDiv(animal);
        body.append(parentDiv.toString());
        return document;
    }

    public static Document createDocumentStructure(List<Animal> animals) {
        Document document = HtmlConverter.createNewDocument("My Zoo");
        Element body = document.body();
        animals.forEach(animal -> {
            Element parentDiv = createAnimalDiv(animal);
            body.append(parentDiv.toString());
        });
        return document;
    }
}
