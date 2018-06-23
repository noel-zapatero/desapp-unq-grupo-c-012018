package main.services;

import main.model.*;
import main.model.builders.PublicationBuilder;
import main.model.dtos.PublicationDto;
import main.model.dtos.VehicleDto;

import java.util.ArrayList;
import java.util.List;

public class PublicationService extends GenericService<Publication> {
  private static final long serialVersionUID = -2932116622242535843L;

  private VehicleService vehicleService;
  private UserService userService;
  private AvailabilityService availabilityService;

  public void setVehicleService(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setAvailabilityService(AvailabilityService availabilityService) {this.availabilityService=availabilityService;}

  public void acceptReservation(Publication p, Reservation r) {
    p.acceptReservation(r);
    this.update(p);
  }

  public void declineReservation(Publication p, Reservation r) {
    p.declineReservation(r);
    this.update(p);
  }

  public List<Publication> getPublicationsFromUserEmail(String userEmail) {
    List<Publication> ret = new ArrayList<>();
    for (Publication p: retriveAll()) {
      if (p.getOwnerEmail() == userEmail) {
        ret.add(p);
      }
    }
    return ret;
  }

  public List<PublicationDto> retriveAllDtos() {
    return toDtos(retriveAll());
  }

  public List<PublicationDto> getPublicationsFromUserEmailAsDto(String userEmail) {
    return toDtos(getPublicationsFromUserEmail(userEmail));
  }

  public List<PublicationDto> toDtos(List<Publication> publications) {
    List<PublicationDto> ret = new ArrayList<>();
    for (Publication p: publications) {
      ret.add(new PublicationDto(p));
    }
    return ret;
  }

  public void createPublicationFromDto(PublicationDto pDto) {
    Vehicle vehicleOffered = vehicleService.findById(pDto.getVehicleOfferedId());
    Publication p = new PublicationBuilder()
      .withPublicationId(pDto.getPublicationId())
        .withOwner(userService.findByEmail(vehicleOffered.getOwner().getEmail()))
      .withVehicle(vehicleOffered)
      .withAvailability(Availability.FromPublicationDto(pDto))
      .build();

    availabilityService.save(p.getAvailability());
    save(p);
  }

  public void deleteById(int id) {
    delete(findById(id));
  }
}
