package main.services;

import main.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService extends GenericService<Vehicle> {

  private static final long serialVersionUID = -2932116622242535843L;

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
    Vehicle v = this.findById(vehicleId);
    v.setDisabled(true);
    this.update(v);
    return true;
  }

  // TODO: refactorizar como hql a la base, esto es poco performante!!
  public List<Vehicle> getVehiclesFrom(int vehicleId) {
//    return this.retriveAll()
//      .stream()
//      .filter(elt -> elt.getVehicleId() == vehicleId)
//      .collect(Collectors.toList());

    List<Vehicle> vehicles = new ArrayList<>();

    for (Vehicle vehicle: retriveAll()){
      if (vehicle.getVehicleId() == vehicleId){
        vehicles.add(vehicle);
      }
    }

    return vehicles;
  }
}
