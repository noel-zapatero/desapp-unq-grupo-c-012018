package main.model.builders;

import main.model.availability.Availability;
import main.model.Publication;
import main.model.User;
import main.model.Vehicle;
import main.model.availability.NotAvailable;

public class PublicationBuilder {

  private Vehicle vehicle;
  private User owner;
  private Availability availability = new NotAvailable();

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

  public PublicationBuilder withAvailability(Availability availability) {
    this.availability = availability;
    return this;
  }
}
