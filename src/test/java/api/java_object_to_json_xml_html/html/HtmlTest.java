package api.java_object_to_json_xml_html.html;

import api.java_object_to_json_xml_html.Animal;
import api.java_object_to_json_xml_html.Cat;
import api.java_object_to_json_xml_html.Dog;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class HtmlTest {

    @Test
    public  void testCatToHTML() throws IOException {
        Cat cat = new Cat("Black", 2, "Murka");
        String html = AnimalToHtmlConverter.createDocumentStructure(cat).html();
        System.out.println(html);
        FileUtils.write(new File("C:\\My_git_repos\\my_downloads\\converters\\cat.html"), html, Charset.defaultCharset());
    }

    @Test
    public  void testArrayAnimalsHTML() throws IOException {
        Cat murka = new Cat("Black", 2, "Murka");
        Dog drug = new Dog("White", 1, "Drug");
        Cat pushok = new Cat("Grey", 3, "Pushok");
        Animal yashka = new Animal("White", 13, "Yashka");
        String html = AnimalToHtmlConverter.createDocumentStructure(Arrays.asList(murka, drug, pushok, yashka)).html();
        System.out.println(html);
        FileUtils.write(new File("C:\\My_git_repos\\my_downloads\\converters\\animals.html"), html, Charset.defaultCharset());
    }

    @Test
    public void testJoinDocuments() throws IOException {
        Cat murka = new Cat("Black", 2, "Murka");
        Dog drug = new Dog("White", 1, "Drug");
        Cat pushok = new Cat("Grey", 3, "Pushok");
        Document doc1 = AnimalToHtmlConverter.createDocumentStructure(murka);
        Document doc2 = AnimalToHtmlConverter.createDocumentStructure(drug);
        Document doc3 = AnimalToHtmlConverter.createDocumentStructure(pushok);
        String html = HtmlConverter.joinDocument(Arrays.asList(doc1,doc2,doc3), "My Pets").html();
        FileUtils.write(new File("C:\\My_git_repos\\my_downloads\\converters\\joinDocuments.html"), html, Charset.defaultCharset());
    }
}
