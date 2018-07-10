package main.services;

public class VehicleType {
  private String type;

  public VehicleType(String vehicleType) {
    if (ek(vehicleType, "auto"))
      this.type = "Auto";
    else if (ek(vehicleType, "moto"))
      this.type = "Moto";
    else if (ek(vehicleType, "pickup"))
      this.type = "Pickup";
  }

  private boolean ek(String vehicleType, String type) {
    return vehicleType.toLowerCase().equals("auto");
  }

  public String getType() {
    return type;
  }
}
