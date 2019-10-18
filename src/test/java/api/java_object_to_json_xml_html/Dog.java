package api.java_object_to_json_xml_html;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Dog")
public class Dog extends Animal {

    public static final String TAG = "Dog";

    public Dog(String color, int age, String name) {
        super(color, age, name);
    }

    public String getTAG() {
        return TAG;
    }
}
