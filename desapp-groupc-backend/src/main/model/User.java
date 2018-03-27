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
    private Carpnd page;

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

    public void createVehicle(){
        //check vehicle constructor
        Vehicle newVehicle = new Vehicle();
        this.myVehicles.add(newVehicle);
        this.page.createVehicle(newVehicle);
    }

    public void makeNewOffer (Vehicle myVehicle){
        //check that myVehicle is already added to "myVehicles" list
        Publication newPub = new Publication(myVehicle);
        myOffers.add(newPub);
        page.publish(newPub);
    }

    public void chargeCredits(float moreCred){
        this.credits += moreCred;
    }

    public void whitdrawCredits(float creds){
        this.credits -= creds;
    }

    public void bookVehicle(){}
    public void acceptReservation(){}

    public void pickUpDone(){}
    public void acceptPickUp(){}

    //On the return, rating must be done from both sides
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

    public void setPage(Carpnd page) {
        this.page = page;
    }

    public float getCredits() {
        return credits;
    }

    public float getRating() {
        return rating;
    }
}
