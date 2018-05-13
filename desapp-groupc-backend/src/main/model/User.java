package main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  @Column(name = "cuil")
  public Cuil cuil;

  @Column(name = "lastName")
  public String lastName;
  @Column(name = "firstname")
  public String firstName;
  @Column(name = "address")
  public String address;
  @Column(name = "email")
  public Email email;
  @Column(name = "rating")
  public float rating;
  @Column(name = "credits")
  public float credits;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "vehicles")
  public List<Vehicle> myVehicles;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "publications")
  public List<Publication> myOffers;

  private List<Integer> totalRatings;
  public List<Vehicle> vehiclesRented;
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

  public int getId() {
    return userId;
  }
}
