package main.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  @Column
  public Long cuil;

  @Column
  public String lastName;

  @Column
  public String firstName;

  @Column
  public String address;

  @Column
  public String email;

  @Column
  public float rating;

  @Column
  public float credits;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "USER_VEHICLES")
  public List<Vehicle> myVehicles;

  @OneToMany(fetch = FetchType.EAGER)
  public List<Publication> myOffers;

  @Transient
  private List<Integer> totalRatings;

  public User() {}

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

  public void chargeCredits(float moreCred){
        this.credits += moreCred;
    }

    public void addVehicle(Vehicle v) {
      this.myVehicles.add(v);
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

  public int getId() {
    return userId;
  }

  public Long getCuil() {
    return cuil;
  }

  public String getAddress() {
    return this.address;
  }

  public List<Vehicle> getVehicles() {
    return this.myVehicles;
  }

  public String getLastName() {
    return lastName;
  }

  public void setCredits(float credits) {
    this.credits = credits;
  }
}
