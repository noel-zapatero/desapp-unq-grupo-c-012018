package main.model.builders;

import main.model.Availability;
import main.model.Vehicle;

public class VehicleBuilder {

  private Vehicle vehicle = new Vehicle();

  private Availability availability = new Availability(null, null);

  public Vehicle build() {
    vehicle.setAvailability(availability);
    return vehicle;
  }

  public VehicleBuilder withAvailability(Availability availability) {
    this.availability = availability;
    return this;
  }
}
