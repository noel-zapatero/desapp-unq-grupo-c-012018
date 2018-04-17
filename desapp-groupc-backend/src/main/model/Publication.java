package main.model;

import main.model.availability.Availability;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Publication {

    public User owner;
    public Vehicle vehicleOffered;

    private Availability availability;

    private List<Reservation> reservations = new ArrayList<Reservation>();
    private List<Reservation> acceptedReservations = new ArrayList<Reservation>();

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
