package api.java_object_to_json_xml_html;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Cat")
public class Cat extends Animal{

    public static final String TAG = "Cat";

    public Cat(String color, int age, String name) {
        super(color, age, name);
    }
    public String getTAG() {
        return TAG;
    }
}
