package main.model;

import java.util.List;

public class Carpnd {

    List<Publication> offers;
    List<User> users;
    List<Vehicle> allVehicles;

    public void register(int cuil, String lastName, String firstName, String address, String email){
        User newUser = new User(cuil,lastName,firstName,address,email);
        newUser.setPage(this);
        this.users.add(newUser);
    }

    public void createVehicle(Vehicle vehicle){
        this.allVehicles.add(vehicle);
    }

    public void publish(Publication pub){
        this.offers.add(pub);
    }
}
