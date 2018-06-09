package main.model.builders;

import main.model.User;
import main.model.Vehicle;

import java.util.List;

public class VehicleBuilder {

  private int vehicleId;
  private int passengerCapacity = 4;
  private String type;
  private String zone;
  private String withdrawAddress;
  private String returnAddresses;
  private String description;
  private String contactPhone;
  private float rentFeeDay;
  private float rentFeeHour;
  private User owner;
  private String imageUrl;

  public Vehicle build() {
    Vehicle v = new Vehicle();

    v.setVehicleId(vehicleId);
    v.setType(type);
    v.setZone(zone);
    v.setWithdrawAddress(withdrawAddress);
    v.setReturnAddresses(returnAddresses);
    v.setDescription(description);
    v.setContactPhone(contactPhone);
    v.setRentFeeHour(rentFeeHour);
    v.setRentFeeDay(rentFeeDay);
    v.setPassengerCapacity(passengerCapacity);
    v.setOwner(owner);
    v.setImageUrl(imageUrl);

    return v;
  }

  public VehicleBuilder withPassengerAmmount(int x) {
    this.passengerCapacity = x;
    return this;
  }

  public VehicleBuilder withVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  public VehicleBuilder withType(String type) {
    this.type = type;
    return this;
  }

  public VehicleBuilder withPassengerCapacity(int x) {
    this.passengerCapacity = x;
    return this;
  }

  public VehicleBuilder withZone(String zone) {
    this.zone = zone;
    return this;
  }

  public VehicleBuilder withWithDrawAddress(String withdrawAddress) {
    this.withdrawAddress = withdrawAddress;
    return this;
  }

  public VehicleBuilder withReturnAddresses(String returnAddresses) {
    this.returnAddresses = returnAddresses;
    return this;
  }

  public VehicleBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public VehicleBuilder withContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public VehicleBuilder withRentFeeDay(float rentFeeDay) {
    this.rentFeeDay = rentFeeDay;
    return this;
  }

  public VehicleBuilder withRentFeeHour(float rentFeeHour) {
    this.rentFeeHour = rentFeeHour;
    return this;
  }

  public VehicleBuilder withOwner(User owner) {
    this.owner = owner;
    return this;
  }

  public VehicleBuilder withImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }
}
