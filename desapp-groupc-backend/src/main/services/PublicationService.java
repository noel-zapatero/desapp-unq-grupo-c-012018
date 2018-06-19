package main.services;

import main.model.Availability;
import main.model.Publication;
import main.model.Reservation;
import main.model.builders.PublicationBuilder;
import main.repositories.VehicleRepository;
import org.joda.time.DateTime;

public class PublicationService extends GenericService<Publication> {
  private static final long serialVersionUID = -2932116622242535843L;

  private VehicleRepository vehicleRepository;

  public void setVehicleRepository(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  public Publication createPublication(Integer vehicleId) {
    Publication pub = new PublicationBuilder()
      .withVehicle(vehicleRepository.findVehicleById(vehicleId))
      .withOwner(vehicleRepository.findVehicleById(vehicleId).getOwner())
      .withAvailability(new Availability(DateTime.now(),DateTime.now().plusDays(5)))
      .build();
    this.save(pub);
    return pub;
  }

  public void acceptReservation(Publication p, Reservation r) {
    p.acceptReservation(r);
    this.update(p);
  }

  public void declineReservation(Publication p, Reservation r) {
    p.declineReservation(r);
    this.update(p);
  }
}
