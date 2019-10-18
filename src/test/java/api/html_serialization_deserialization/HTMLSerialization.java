package api.html_serialization_deserialization;

import org.apache.juneau.html.HtmlParser;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.internal.IOUtils;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class HTMLSerialization {

    @Test
    public void testSerialization() throws SerializeException, IOException {
        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;

        String[] nickNames = {"Jil", "Bil", "Rock"};
        Person person = new Person("Jackson", "Colombo", 24, nickNames);

        String htmlCode = htmlSerializer.serialize(person);
        System.out.println(htmlCode);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\My_git_repos\\my_downloads\\index.html"));
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));

        dataOutputStream.writeBytes(htmlCode);
        dataOutputStream.close();
    }

    @Test
    public void testDeserialization() throws SerializeException, IOException, ParseException {
        HtmlParser htmlParser = HtmlParser.create().ignoreUnknownBeanProperties().build();

//        String htmlCode = IOUtils.read(new File("C:\\My_git_repos\\my_downloads\\index.html"));
//
//        Person person = htmlParser.parse(htmlCode, Person.class);
//
//        Assert.assertEquals(person.getAge(), 24, "Assert person's age");

        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;

        String[] nickNames = {"Jil", "Bil", "Rock"};
        Person person = new Person("Jackson", "Colombo", 24, nickNames);

        String htmlCode = htmlSerializer.serialize(person);

//        Person person1 = htmlParser.parse(htmlCode, Person.class);
    }
}
