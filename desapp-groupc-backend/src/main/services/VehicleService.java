package main.services;

import main.model.Vehicle;
import main.model.builders.VehicleBuilder;
import main.model.dtos.VehicleDto;
import main.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService extends GenericService<Vehicle> {

  private static final long serialVersionUID = -2932116622242535843L;

  private UserService userService;

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  // TODO: estos metodos hacen solo la parte feliz y no checkean nada!

  public boolean createVehicle(Vehicle v) {
    this.save(v);
    return true;
  }

  public boolean updateVehicle(Vehicle v) {
    this.update(v);
    return true;
  }

  public boolean disableVehicle(Integer vehicleId) {
    delete(findById(vehicleId));
    return true;
  }

  // TODO: refactorizar como hql a la base, esto es poco performante!!
  public List<Vehicle> getVehiclesFrom(int userId) {
//    return this.retriveAll()
//      .stream()
//      .filter(elt -> elt.getId() == userId)
//      .collect(Collectors.toList());

    List<Vehicle> vehicles = new ArrayList<>();

    for (Vehicle vehicle: retriveAll()){
      if (vehicle.getOwner().getId() == userId){
        vehicles.add(vehicle);
      }
    }

    return vehicles;
  }


  public VehicleDto createVehicleFromDto(VehicleDto vDto) {
    Vehicle vehicle = new VehicleBuilder()
      .withContactPhone(vDto.getContactPhone())
      .withDescription(vDto.getDescription())
      .withPassengerAmmount(vDto.getPassengerCapacity())
      .withReturnAddresses(vDto.getReturnAddress())
      .withType(vDto.getType())
      .withWithDrawAddress(vDto.getWithdrawAddress())
      .withZone(vDto.getZone())
      .withOwner(userService.findByEmail(vDto.getOwnerEmail()))
      .withImageUrl(vDto.getImageUrl())
      .withBrandModel(vDto.getBrandModel())
      .build();

    save(vehicle);

    return new VehicleDto(vehicle);
  }

  public boolean updateVehicleFromDto(VehicleDto vDto) {
    Vehicle v = vDto.toVehicle();
    v.setOwner(userService.findById(vDto.getOwnerId()));
    this.update(v);
    return true;
  }

  public List<Vehicle> getVehiclesFromEmail(String email) {
    return getVehiclesFrom(userService.findByEmail(email).getId());
  }

  public List<VehicleDto> filterByType(String type) {
    List<VehicleDto> ret = new ArrayList<>();
    for (Vehicle v: ((VehicleRepository) getRepository()).filterByType(type)) {
      ret.add(new VehicleDto(v));
    }
    return ret;
  }
}
