package main.services;

import main.model.Vehicle;

public class VehicleService extends GenericService<Vehicle> {

  private static final long serialVersionUID = -2932116622242535843L;

  // TODO: validar!
  public boolean createVehicle(Vehicle v) {
    this.save(v);
    return true;
  }

  // TODO: validar!
  public boolean updateVehicle(Vehicle v) {
    this.update(v);
    return true;
  }

  // TODO: hacer que se marque como deshabilitado (PERO NO BORRAR) el vehiculo que
  // tenga como id vehicleId
  public boolean disableVehicle(Integer vehicleId) {
    return false;
  }
}
