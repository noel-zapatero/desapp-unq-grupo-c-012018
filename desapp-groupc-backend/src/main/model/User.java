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
    private List<Integer> totalRatings;
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
        this.totalRatings = new ArrayList<Integer>();
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

    public String getEmail() {
      return email;
    }
}