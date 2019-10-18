package api.java_object_to_json_xml_html;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Animal")
public class Animal {

    @JacksonXmlProperty(localName = "Color")
    private String color;
    @JacksonXmlProperty(localName = "Age")
    private int age;
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JsonIgnore
    public static final String TAG = "Animal";

    public Animal(String color, int age, String name) {
        this.color = color;
        this.age = age;
        this.name = name;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTAG() {
        return TAG;
    }
}
