package main.model;

import java.util.ArrayList;
import java.util.List;

public class Carpnd {

    List<Publication> offers;
    List<User> users;
    List<Vehicle> allVehicles;

    public Carpnd(){
      this.offers = new ArrayList<Publication>();
      this.users = new ArrayList<User>();
      this.allVehicles = new ArrayList<Vehicle>();
    }

    public void register(int cuil, String lastName, String firstName, String address, String email){
        User newUser = new User(cuil,lastName,firstName,address,email);
        newUser.setPage(this);
        this.users.add(newUser);
    }

    public void createVehicle(Vehicle vehicle){
        this.allVehicles.add(vehicle);
    }

    
  public void bookVehicle(String bidderName, Publication pub){
    EmailSender.SendBookMessage(bidderName, pub.getOwnerEmail());
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
  public void returnDone(Publication pub, Integer rate){
    EmailSender.SendReturnMessage(pub.getOwnerEmail());
    rateCounterPart(pub.getOwner(), rate, "");
  }
  public void acceptReturn(String receiptEmail, User bidder, Integer rate){
    EmailSender.AcceptReturn(receiptEmail);
    rateCounterPart(bidder, rate, "");
  }

  public void rateCounterPart(User otherUser, Integer rating, String comments){
    this.rateCounterPart(otherUser,rating);
    String comment = comments;
  }

  public void rateCounterPart(User otherUser, Integer rating){
    otherUser.receiveRating(rating); //Rating must be a float between 0 and 5
  }

    //TODO: Search
    //TODO: Auto-ban rating
    //TODO: Account states at the end of the month
    //TODO: AFIP validation
}
