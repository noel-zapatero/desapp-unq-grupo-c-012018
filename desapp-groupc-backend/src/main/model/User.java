package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int cuil;
    public String lastName;
    public String firstName;
    public String address;
    public String email;

    public float rating;
    private int amountOfRatings;
    public float credits;
    public List<Vehicle> myVehicles;
    public List<Vehicle> vehiclesRented;
    public List<Publication> myOffers;

    public User(int cuil, String lastName, String firstName, String address, String email){
        this.cuil = cuil;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.credits = 0;
        this.rating = 0;
        this.amountOfRatings = 0;
        myVehicles = new ArrayList<Vehicle>();
        vehiclesRented = new ArrayList<Vehicle>();
        myOffers = new ArrayList<Publication>();
    }

    public void addVehicle (Vehicle newVehicle){
        this.myVehicles.add(newVehicle);
    }

    public void chargeCredits(float moreCred){
        this.credits += moreCred;
    }

    public void whitdrawCredits(float creds){
        this.credits -= creds;
    }

    public void makeNewOffer (Vehicle myVehicle){
        //check that myVehicle is already added to "myVehicles" list
        myOffers.add(new Publication(myVehicle));
    }

    public void bookVehicle(){}
    public void acceptReservation(){}

    public void pickUpDone(){}
    public void acceptPickUp(){}

    public void returnDone(){}
    public void acceptReturn(){}

    public void rateCounterPart(User otherUser, float rating, String comments){
        //check comments
        otherUser.receiveRating(rating); //Rating must be a float between 0 and 5
    }

    public void receiveRating(float rating){
        this.amountOfRatings++;
        this.rating = (this.rating+=rating) / this.amountOfRatings;
    }

    public String getName() {
        return firstName;
    }
}
