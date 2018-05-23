package main.services;

import main.model.Vehicle;

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
}
