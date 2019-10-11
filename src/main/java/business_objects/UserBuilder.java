package business_objects;

public class UserBuilder {

    private User user = new User();

    public UserBuilder withId(int id) {
        user.setId(id);
        return this;
    }

    public UserBuilder withName(String name) {
        user.setName(name);
        return this;
    }
    public UserBuilder withUsername(String username) {
        user.setUsername(username);
        return this;
    }
    public UserBuilder withEmail(String email) {
        user.setEmail(email);
        return this;
    }
    public UserBuilder withAddress(Address address) {
        user.setAddress(address);
        return this;
    }

    public UserBuilder withPhone(String phone) {
        user.setPhone(phone);
        return this;
    }

    public UserBuilder withWebsite(String website) {
        user.setWebsite(website);
        return this;
    }

    public UserBuilder withCompany(Company company) {
        user.setCompany(company);
        return this;
    }

    public User build() {
        return user;
    }
}
