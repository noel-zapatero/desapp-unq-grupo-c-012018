package main.model;

import org.joda.time.DateTime;

public class Publication {

    public User owner;
    public Vehicle vehicleOffered;
    private Availability availability;

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
    return availability.isAvailable(start, end);
  }
}
