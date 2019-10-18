package api.java_object_to_json_xml_html.xml;

import api.java_object_to_json_xml_html.Animal;
import api.java_object_to_json_xml_html.Cat;
import api.java_object_to_json_xml_html.Dog;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class XMLTest {

    @Test
    public void testXML() throws IOException, ParserConfigurationException, TransformerException {
        Cat cat = new Cat("Black", 2, "Murka");
        Document document = AnimalToXMLConverter.createDocumentStructure(cat);
        String prettyDocument = XMLConverter.prettyPrint(document);
        FileUtils.writeStringToFile(new File("C:\\My_git_repos\\my_downloads\\converters\\cat.xml"), prettyDocument, Charset.defaultCharset());
    }

    @Test
    public void testXMLArray() throws IOException, ParserConfigurationException, TransformerException {
        Cat murka = new Cat("Black", 2, "Murka");
        Cat snowflake = new Cat("White", 1, "Snowflake");
        Cat vasia = new Cat("Grey", 3, "Vasiliy");
        Document document = AnimalToXMLConverter.createDocumentStructure(Arrays.asList(murka, snowflake, vasia));
        String prettyDocument = XMLConverter.prettyPrint(document);
        FileUtils.writeStringToFile(new File("C:\\My_git_repos\\my_downloads\\converters\\cats.xml"), prettyDocument, Charset.defaultCharset());
    }

    @Test
    public void testXMLZoo() throws IOException, ParserConfigurationException, TransformerException {
        Cat murka = new Cat("Black", 2, "Murka");
        Dog druzhok = new Dog("White", 3, "Druzhok");
        Animal vasia = new Cat("Grey", 3, "Vasiliy");
        Animal yashka = new Animal("White", 13, "Yashka");
        Document document = AnimalToXMLConverter.createDocumentStructure(Arrays.asList(murka, druzhok, vasia, yashka));
        String prettyDocument = XMLConverter.prettyPrint(document);
        FileUtils.writeStringToFile(new File("C:\\My_git_repos\\my_downloads\\converters\\animals.xml"), prettyDocument, Charset.defaultCharset());
    }

    @Test
    public void testDocumentIntoDocument() throws ParserConfigurationException, TransformerException, IOException {
        Cat murka = new Cat("Black", 2, "Murka");
        Dog druzhok = new Dog("White", 3, "Druzhok");
        Document document1 = AnimalToXMLConverter.createDocumentStructure(Arrays.asList(murka));
        Document document2 = AnimalToXMLConverter.createDocumentStructure(druzhok);
        Document result = XMLConverter.insertDocumentIntoDocument(document1, document2);
        String prettyDocument = XMLConverter.prettyPrint(result);
        FileUtils.writeStringToFile(new File("C:\\My_git_repos\\my_downloads\\converters\\insertdocuments.xml"), prettyDocument, Charset.defaultCharset());
    }

    @Test
    public void testJoinDocuments() throws ParserConfigurationException, TransformerException, IOException {
        Cat murka = new Cat("Black", 2, "Murka");
        Dog druzhok = new Dog("White", 3, "Druzhok");
        Animal vasia = new Cat("Grey", 3, "Vasiliy");
        Document document1 = AnimalToXMLConverter.createDocumentStructure(murka);
        Document document2 = AnimalToXMLConverter.createDocumentStructure(druzhok);
        Document document3 = XMLConverter.joinDocuments(Arrays.asList(document1, document2), "Pets");
        Document result = XMLConverter.insertDocumentIntoDocument(document3, AnimalToXMLConverter.createDocumentStructure(vasia));
        String prettyDocument = XMLConverter.prettyPrint(result);
        FileUtils.writeStringToFile(new File("C:\\My_git_repos\\my_downloads\\converters\\documentsJoin.xml"), prettyDocument, Charset.defaultCharset());
    }

}
