package main.model;

import main.model.availability.Availability;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publications")
public class Publication {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "users")
  public User owner;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinTable(name = "vehicles")
  public Vehicle vehicleOffered;
  @Column(name = "availability")
  private Availability availability;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "reservations")
  private List<Reservation> reservations = new ArrayList<Reservation>();

  private List<Reservation> acceptedReservations = new ArrayList<Reservation>();

  public Publication (Vehicle newVehicle, User owner, Availability availability){
    this.availability = availability;
    this.owner = owner;
    this.vehicleOffered = newVehicle;
  }

  public String getOwnerEmail() {
    return this.owner.getEmail().getAddress();
  }

  public User getOwner() {
    return owner;
  }

  public boolean isAvailable(DateTime start, DateTime end) {
      return this.availability.isAvailable(start, end) && !this.isBooked(start, end);
  }

  private boolean isBooked(DateTime start, DateTime end) {
    boolean ret = false;
    for (Reservation r: acceptedReservations) {
      ret = ret || r.conflictsWith(start, end);
    }
    return ret;
  }

  public Reservation book(DateTime start, DateTime end, String user) {
      Reservation r = new Reservation(start, end, user, this);
      this.reservations.add(r);
      return r;
  }

  public void acceptReservation(Reservation reservation) {
    this.acceptedReservations.add(reservation);
    this.reservations.remove(reservation);
  }
}
