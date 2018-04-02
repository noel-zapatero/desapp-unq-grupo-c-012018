package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public long cuil;
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

    public User(long cuil, String lastName, String firstName, String address, String email){
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
        Publication newPub = new Publication(myVehicle, this);
        myOffers.add(newPub);
        page.publish(newPub);
    }

    public void chargeCredits(float moreCred){
        this.credits += moreCred;
    }

    public void whitdrawCredits(float creds){
        this.credits -= creds;
    }

    public void bookVehicle(Publication pub){
      EmailSender.SendBookMessage(this.firstName, pub.getOwnerEmail());
    }

    //TODO: Check credit discount
    public void acceptReservation(String receiptEmail){
      EmailSender.AcceptReservation(receiptEmail);
    }

    public void pickUpDone(Publication pub){
      EmailSender.SendPickUpMessage(pub.getOwnerEmail());
    }
    public void acceptPickUp(String receiptEmail){
      EmailSender.AcceptPickUp(receiptEmail);
    }

    //On the return, rating must be done from both sides
    public void returnDone(Publication pub, float rate){
      EmailSender.SendReturnMessage(pub.getOwnerEmail());
      rateCounterPart(pub.getOwner(), rate, " ");
    }
    public void acceptReturn(String receiptEmail, User bidder, float rate){
      EmailSender.AcceptReturn(receiptEmail);
      rateCounterPart(bidder, rate, "");
    }

    public void rateCounterPart(User otherUser, float rating, String comments){
        //TODO: check comments, may not be
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

    public String getEmail() {
      return email;
    }
}
