package main.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public Cuil cuil;
    public String lastName;
    public String firstName;
    public String address;
    public Email email;

    public float rating;
    private List<Integer> totalRatings;
    public float credits;
    public List<Vehicle> myVehicles;
    public List<Vehicle> vehiclesRented;
    public List<Publication> myOffers;
    private Carpnd page;

    public User(long cuil, String lastName, String firstName, String address, String email){


        this.cuil = new Cuil(cuil);
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = new Email(email);
        this.credits = 0;
        this.rating = 0;
        this.totalRatings = new ArrayList<Integer>();
        myVehicles = new ArrayList<Vehicle>();
        vehiclesRented = new ArrayList<Vehicle>();
        myOffers = new ArrayList<Publication>();
    }

  /**
   * funca para firstName y lastName
   * @param name
   * @return
   */
  private boolean isValidName(String name) {
      return name.length() >= 4 && name.length() <= 50;
    }

    public void createVehicle(){
        //check vehicle constructor
        Vehicle newVehicle = new Vehicle();
        this.myVehicles.add(newVehicle);
        this.page.createVehicle(newVehicle);
    }

    public void chargeCredits(float moreCred){
        this.credits += moreCred;
    }

    public void whitdrawCredits(float creds){
        this.credits -= creds;
    }

    public void receiveRating(Integer rating){
        this.totalRatings.add(rating);
        float rate = 0;
        int i;
        for (i=0; i < this.totalRatings.size(); i++) {
              rate += this.totalRatings.get(i);
        }
        this.rating = rate / this.totalRatings.size();
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

    public double getRating() {
      double d = Math.pow(10,2);
      return (Math.round(this.rating * d) / d);
    }

    public Email getEmail() {
      return email;
    }
}
