package main.model;

import java.util.ArrayList;
import java.util.List;

public class Carpnd {

  //private List<Publication> offers;
  private List<User> users;
  private List<Vehicle> allVehicles;
  private String cacheComment;

  public Carpnd(){
    //this.offers = new ArrayList<Publication>();
    this.users = new ArrayList<User>();
    this.allVehicles = new ArrayList<Vehicle>();
    this.cacheComment = "";
  }

  public void register(int cuil, String lastName, String firstName, String address, String email){
    User newUser = new User(cuil,lastName,firstName,address,email);
    this.users.add(newUser);
  }

  public void createVehicle(Vehicle vehicle){
        this.allVehicles.add(vehicle);
    }


  public void bookVehicle(String bidderName, Publication pub){
    EmailSender.sendBookMessage(bidderName, pub.getOwnerEmail());
  }

  //TODO: Check credit discount
  public void acceptReservation(String receiptEmail){
    EmailSender.acceptReservation(receiptEmail);
  }

  public void pickUpDone(Publication pub){
    EmailSender.sendPickUpMessage(pub.getOwnerEmail());
  }
  public void acceptPickUp(String receiptEmail){
    EmailSender.acceptPickUp(receiptEmail);
  }

  //On the return, rating must be done from both sides
  public void returnDone(Publication pub, Integer rate){
    EmailSender.sendReturnMessage(pub.getOwnerEmail());
    rateCounterPart(pub.getOwner(), rate, "");
  }
  public void acceptReturn(String receiptEmail, User bidder, Integer rate){
    EmailSender.acceptReturn(receiptEmail);
    rateCounterPart(bidder, rate, "");
  }

  public void rateCounterPart(User otherUser, Integer rating, String comments){
    this.rateCounterPart(otherUser,rating);
    this.cacheComment = comments;
  }

  public void rateCounterPart(User otherUser, Integer rating){
    otherUser.receiveRating(rating); //Rating must be a float between 0 and 5
  }

    //TODO: Search
    //TODO: Auto-ban rating
    //TODO: Account states at the end of the month
    //TODO: AFIP validation
}
