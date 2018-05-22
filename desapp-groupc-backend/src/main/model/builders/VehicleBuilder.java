package main.model.builders;

import main.model.Vehicle;

public class VehicleBuilder {

  private int passengerCapacity = 4;

  public Vehicle build() {
    Vehicle v = new Vehicle();

    v.setPassengerCapacity(passengerCapacity);

    return v;
  }

  public VehicleBuilder withPassengerAmmount(int x) {
    this.passengerCapacity = x;
    return this;
  }
}
