package api.html_serialization_deserialization;

public class Person {

    private String name;
    private String city;
    private int age;
    private String[] nickNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public Person(String name, String city, int age, String[] nickNames) {
        super();
        this.name = name;
        this.city = city;
        this.age = age;
        this.nickNames = nickNames;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getNickNames() {
        return nickNames;
    }

    public void setNickNames(String[] nickNames) {
        this.nickNames = nickNames;
    }
}
