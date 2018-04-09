package main.model.builders;

import main.model.Availability;
import main.model.Publication;
import main.model.User;
import main.model.Vehicle;

public class PublicationBuilder {

  private Vehicle vehicle;
  private User owner;
  private Availability availability;

  public PublicationBuilder withVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    return this;
  }

  public Publication build() {
    return new Publication(vehicle, owner, availability);
  }

  public PublicationBuilder withOwner(User owner) {
    this.owner = owner;
    return this;
  }
}
