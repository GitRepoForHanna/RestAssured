package api.java_object_to_json_xml_html;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JSONTest {

    @Test
    public void testJSON() throws IOException {
        Cat cat = new Cat("Grey", 3, "Kitty");
        JsonMapper mapper = new JsonMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\My_git_repos\\my_downloads\\converters\\cat.json"), cat);
    }

    @Test
    public void testAnimalsArrayJSON() throws IOException {
        Cat kitty = new Cat("Grey", 3, "Kitty");
        Dog druzhok = new Dog("White", 3, "Druzhok");
        Animal vasia = new Cat("Grey", 3, "Vasiliy");
        JsonMapper mapper = new JsonMapper();
        Animal[] animals = {kitty, druzhok, vasia};
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("C:\\My_git_repos\\my_downloads\\converters\\animals.json"), animals);
    }

}
