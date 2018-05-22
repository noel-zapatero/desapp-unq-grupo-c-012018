package main.model.builders;

import main.model.User;

public class UserBuilder {

    private Long cuil = 20337778881L;
    private String lastName = "No lastname";
    private String firstName = "No name";
    private String address = "No address";
    private String email = "No@email.com";

    public User build() {
        User user = new User(cuil,lastName,firstName,address,email);
        return user;
    }

    public UserBuilder withNameAndLastName(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withAddress(String address){
        this.address = address;
        return this;
    }

    public UserBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder withCuil(long cuil){
        this.cuil = cuil;
        return this;
    }
}
