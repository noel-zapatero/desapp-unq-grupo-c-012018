package main.model;

import main.model.exceptions.ReservationException;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publication {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int publicationId;

  @OneToOne
  public User owner;

  @OneToOne
  public Vehicle vehicleOffered;

  @OneToOne
  public Availability availability;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "PUBLICATION_RESERVATION")
  private List<Reservation> reservations = new ArrayList<Reservation>();

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "PUBLICATION_ACCEPTEDRESERVATION")
  private List<Reservation> acceptedReservations = new ArrayList<Reservation>();
  private int id;

  public Publication() { }

  public Publication (Vehicle newVehicle, User owner, Availability availability){
    this.availability = availability;
    this.owner = owner;
    this.vehicleOffered = newVehicle;
  }

  public String getOwnerEmail() {
    return this.owner.getEmail();
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

  public Reservation book(DateTime start, DateTime end, User user) {
      Reservation r = new Reservation(start, end, user, this);
      this.reservations.add(r);
      return r;
  }

  public void acceptReservation(Reservation reservation) {
    if (isBooked(reservation.getStartDate(), reservation.getEndDate()))
      throw new ReservationException();

    this.acceptedReservations.add(reservation);
    this.reservations.remove(reservation);
  }

  public int getId() {
    return publicationId;
  }

  public void declineReservation(Reservation r) {
    this.reservations.remove(r);
  }
}
