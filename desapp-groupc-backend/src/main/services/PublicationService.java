package main.services;

import main.model.*;
import main.model.builders.PublicationBuilder;
import main.model.dtos.PublicationDto;
import main.repositories.PublicationRepository;

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

  public PublicationRepository getRepository() {
    return this.getRepository();
  }

  public List<PublicationDto> filterByVehicleType(String vehicleType) {
    List<Publication> publications =
      getRepository().filterByVehicleType(new VehicleType(vehicleType));

    return toDtos(publications);
  }

  public List<Publication> getPublicationsFromUserEmail(String userEmail) {
    List<Publication> ret = new ArrayList<>();
    for (Publication p: retriveAll()) {
      if (userEmail.equals(p.getOwnerEmail())) {
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

  public PublicationDto createPublicationFromDto(PublicationDto pDto) {
    Publication p = createPublication(pDto);

    availabilityService.save(p.getAvailability());
    save(p);

    return new PublicationDto(p);
  }

  private Publication createPublication(PublicationDto pDto) {
    Vehicle vehicleOffered = vehicleService.findById(pDto.getVehicleOfferedId());
    return new PublicationBuilder()
      .withPublicationId(pDto.getPublicationId())
      .withOwner(userService.findByEmail(vehicleOffered.getOwner().getEmail()))
      .withVehicle(vehicleOffered)
      .withAvailability(Availability.FromPublicationDto(pDto))
      .withRentFeeHour(pDto.getRentFeeHour())
      .withRentFeeDay(pDto.getRentFeeDay())
      .build();
  }

  public void deleteById(int id) {
    Publication pub = findById(id);
    User owner = userService.findByEmail(pub.getOwnerEmail());
    owner.deletePublication(pub);
    userService.update(owner);
    delete(pub);
  }

  public boolean isOwner(String userEmail, Integer pubId) {
    Publication publication = findById(pubId);
    boolean ret = publication.getOwnerEmail().equals(userEmail);
    return ret;
  }

  public String validate(PublicationDto pDto) {
    String ret = "";
    Publication p = createPublication(pDto);
    if (p.getAvailability().getStart().isAfter(p.getAvailability().getEnd()))
      ret += ", Invalid dates!";
    if (p.getRentFeeDay() < 1)
      ret += ", Invalid rent fee day!";
    if (p.getRentFeeHour() < 1)
      ret += ", Invalid rent fee hour!";
    return ret;
  }

}
