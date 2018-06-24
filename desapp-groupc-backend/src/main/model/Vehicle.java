package main.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int vehicleId;

  @Column
  private String type;

  @Column
  private int passengerCapacity;

  @Column
  private String zone;

  @Column
  private String withdrawAddress;

  @Column
  private String brandModel;

  @Column
  private String description;

  @Column
  private String contactPhone;

  @Column
  boolean disabled = false;

  @OneToOne
  private User owner;

  @Column
  private String returnAddress;

  @Column
  private String imageUrl;

  public Vehicle(){ }

  public String getBrandModel() {
    return brandModel;
  }

  public void setBrandModel(String brandModel) {
    this.brandModel = brandModel;
  }

  public void setReturnAddress(String returnAddress) {
    this.returnAddress = returnAddress;
  }

  public String getType() {return type;}

  public void setType(String type) {this.type = type;}

  public int getPassengerCapacity() {return passengerCapacity;}

  public void setPassengerCapacity(int passengerCapacity) {this.passengerCapacity = passengerCapacity;}

  public String getZone() {return zone;}

  public void setZone(String zone) {this.zone = zone;}

  public String getWithdrawAddress() {return withdrawAddress;}

  public void setWithdrawAddress(String withdrawAddress) {this.withdrawAddress = withdrawAddress;}

//  public String getReturnAddress() {return returnAddress;}

  public void setReturnAddresses(String returnAddresses) {this.returnAddress = returnAddresses;}

  public String getDescription() {return description;}

  public void setDescription(String description) {this.description = description;}

  public String getContactPhone() {return contactPhone;}

  public void setContactPhone(String contactPhone) {this.contactPhone = contactPhone;}

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public int getId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public String getReturnAddress() {
    return returnAddress;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
