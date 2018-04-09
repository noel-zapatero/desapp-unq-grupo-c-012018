package main.model.builders;

import main.model.availability.Availability;
import main.model.Vehicle;
import main.model.availability.Available;

public class VehicleBuilder {

  private Vehicle vehicle = new Vehicle();

  public Vehicle build() {
    return vehicle;
  }
}
