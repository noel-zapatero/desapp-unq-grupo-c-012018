package main.model.builders;

import main.model.Publication;
import main.model.User;
import main.model.Vehicle;

import java.util.List;

public class UserBuilder {

    private int cuil = 00000000000;
    private String lastName = "No name";
    private String firstName = "No lastname";
    private String address = "No address";
    private String email = "No email";

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

    public UserBuilder withCuil(int cuil){
        this.cuil = cuil;
        return this;
    }

}
