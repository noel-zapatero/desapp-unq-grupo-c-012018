package main.model.dtos;

import main.model.Vehicle;
import main.model.builders.VehicleBuilder;

import java.util.List;

public class VehicleDto {

  private int vehicleId;
  private String type;
  private int passengerCapacity;
  private String zone;
  private String withdrawAddress;
  private List<String> returnAddresses;
  private String description;
  private String contactPhone;
  private float rentFeeDay;
  private float rentFeeHour;

  // el dtp es necesario para transportar solo estos datos del duenio y no el objeto entero
  private int ownerId;
  private String ownerName;
  private String ownerLastName;

  public Vehicle toVehicle() {
    return new VehicleBuilder()
      .withVehicleId(vehicleId)
      .withType(type)
      .withPassengerCapacity(passengerCapacity)
      .withZone(zone)
      .withWithDrawAddress(withdrawAddress)
      .withReturnAddresses(returnAddresses)
      .withDescription(description)
      .withContactPhone(contactPhone)
      .withRentFeeDay(rentFeeDay)
      .withRentFeeHour(rentFeeHour)
      .build();
  }

  public VehicleDto() { }

  public VehicleDto(Vehicle v) {
    this.vehicleId = v.getId();
    this.type = v.getType();
    this.passengerCapacity = v.getPassengerCapacity();
    this.zone = v.getZone();
    this.withdrawAddress = v.getWithdrawAddress();
    this.returnAddresses = v.getReturnAddresses();
    this.description = v.getDescription();
    this.contactPhone = v.getContactPhone();
    this.rentFeeDay = v.getRentFeeDay();
    this.rentFeeHour = v.getRentFeeHour();

    this.ownerId = v.getOwner().getId();
    this.ownerName = v.getOwner().getName();
    this.ownerLastName = v.getOwner().getLastName();
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getPassengerCapacity() {
    return passengerCapacity;
  }

  public void setPassengerCapacity(int passengerCapacity) {
    this.passengerCapacity = passengerCapacity;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public String getWithdrawAddress() {
    return withdrawAddress;
  }

  public void setWithdrawAddress(String withdrawAddress) {
    this.withdrawAddress = withdrawAddress;
  }

  public List<String> getReturnAddresses() {
    return returnAddresses;
  }

  public void setReturnAddresses(List<String> returnAddresses) {
    this.returnAddresses = returnAddresses;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public float getRentFeeDay() {
    return rentFeeDay;
  }

  public void setRentFeeDay(float rentFeeDay) {
    this.rentFeeDay = rentFeeDay;
  }

  public float getRentFeeHour() {
    return rentFeeHour;
  }

  public void setRentFeeHour(float rentFeeHour) {
    this.rentFeeHour = rentFeeHour;
  }

  public int getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(int ownerId) {
    this.ownerId = ownerId;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getOwnerLastName() {
    return ownerLastName;
  }

  public void setOwnerLastName(String ownerLastName) {
    this.ownerLastName = ownerLastName;
  }

}
