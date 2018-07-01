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

  @Column
  private float rentFeeDay;

  @Column
  private float rentFeeHour;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "PUBLICATION_RESERVATION")
  private List<Reservation> reservations = new ArrayList<Reservation>();

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "PUBLICATION_ACCEPTEDRESERVATION")
  private List<Reservation> acceptedReservations = new ArrayList<Reservation>();

  public Publication() { }

  public Publication (Vehicle newVehicle, User owner, Availability availability){
    this.availability = availability;
    this.owner = owner;
    this.vehicleOffered = newVehicle;
  }

  public int getPublicationId() {
    return publicationId;
  }

  public float getRentFeeDay() {
    return rentFeeDay;
  }

  public void setRentFeeDay(float rentFeeDay) {
    this.rentFeeDay = rentFeeDay;
  }

  public float getRentFeeHour() {
    return rentFeeHour;
  }

  public void setRentFeeHour(float rentFeeHour) {
    this.rentFeeHour = rentFeeHour;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public List<Reservation> getAcceptedReservations() {
    return acceptedReservations;
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
    reservation.setAccepted(true);
  }

  public int getId() {
    return publicationId;
  }

  public void declineReservation(Reservation r) {
    this.reservations.remove(r);
  }

  public Vehicle getVehicleOffered() {
    return vehicleOffered;
  }

  public Availability getAvailability() {
    return availability;
  }

  public void setPublicationId(int publicationId) {
    this.publicationId = publicationId;
  }

  public void setVehicleOffered(Vehicle vehicleOffered) {
    this.vehicleOffered = vehicleOffered;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public void setAvailability(Availability availability) {
    this.availability = availability;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public void setAcceptedReservations(List<Reservation> acceptedReservations) {
    this.acceptedReservations = acceptedReservations;
  }
}
