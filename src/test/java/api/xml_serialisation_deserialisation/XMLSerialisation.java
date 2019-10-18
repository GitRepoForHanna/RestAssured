package api.xml_serialisation_deserialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class XMLSerialisation {

    public static String XML = "<Person>" +
            "<name>" +
            "Petr" +
            "</name>" +
            "<surname>" +
            "Chudakov" +
            "</surname>" +
            "<age>" +
            "28" +
            "</age>" +
            "<address>" +
            "<street>" +
            "Relington" +
            "</street>" +
            "<city>" +
            "London" +
            "</city>" +
            "</address>" +
            "<address>" +
            "<street>" +
            "AgjaNapi" +
            "</street>" +
            "<city>" +
            "Agja Napa" +
            "</city>" +
            "</address>" +
            "<phoneNumbers>" +
            "<phoneNumbers>" +
            "<number>" +
            "123-56-44-17" +
            "</number>" +
            "</phoneNumbers>" +
            "<phoneNumbers>" +
            "<number>" +
            "846-77-11-24" +
            "</number>" +
            "</phoneNumbers>" +
            "</phoneNumbers>" +
            "</Person>";

    @Test
    public void testSerialisation() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(new Person("Olga", "Mehova", 29));
        Assert.assertNotNull(xml);
    }

    @Test
    public void testDeserialization() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = "<Person>" +
                    "<name>" +
                        "Olga" +
                    "</name>" +
                    "<surname>" +
                        "Mehova" +
                    "</surname>" +
                    "<age>" +
                        "29" +
                    "</age>" +
                "</Person>";
        Person person = xmlMapper.readValue(xml, Person.class);
        System.out.println(person);
    }

    @Test
    public void testSerialization_() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = new Person("Petr", "Chudakov", 28);
        person.setPhoneNumbers(Arrays.asList(new PhoneNumber("123-56-44-17"), new PhoneNumber("846-77-11-24")));
        person.setAddress(Arrays.asList(new Address("Relington", "London"), new Address("AgjaNapi", "Agja Napa")));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream, person);
        System.out.println(byteArrayOutputStream);
    }

    @Test
    public void testDeserialization_() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Person person = xmlMapper.readValue(XML, Person.class);
        Assert.assertEquals(person.getAge(),28, "Assert person age");
        Assert.assertEquals(person.getAddress().get(1).getCity(),"Agja Napa", "Assert person address city");
    }
}
