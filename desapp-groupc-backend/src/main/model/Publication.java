package main.model;

public class Publication {

    public User owner;
    public Vehicle vehicleOffered;

    public Publication (Vehicle newVehicle, User owner){
      this.owner = owner;
      this.vehicleOffered = newVehicle;
    }

  public String getOwnerEmail() {
    return this.owner.getEmail();
  }

  public User getOwner() {
    return owner;
  }
}
