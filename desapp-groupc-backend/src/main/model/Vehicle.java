package main.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "type")
  private String type;

  @Column(name = "capacity")
  private int passengerCapacity;

  @Column(name = "zone")
  private String zone;

  @Column(name = "withdraw_address")
  private String withdrawAddress;

  @ElementCollection(fetch = FetchType.LAZY)
  @Column(name = "return_addresses")
  private List<String> returnAddresses;

  @Column(name = "description")
  private String description;

  @Column(name = "phone")
  private String contactPhone;

  @Column(name = "rentFeeDay")
  private float rentFeeDay;

  @Column(name = "rentFeeHour")
  private float rentFeeHour;

  // TODO: mapear
  @OneToOne
  @JoinTable(name = "users")
  private User owner;

  //Default vehicle. Change
  public Vehicle(){ }

  public String getType() {return type;}

  public void setType(String type) {this.type = type;}

  public int getPassengerCapacity() {return passengerCapacity;}

  public void setPassengerCapacity(int passengerCapacity) {this.passengerCapacity = passengerCapacity;}

  public String getZone() {return zone;}

  public void setZone(String zone) {this.zone = zone;}

  public String getWithdrawAddress() {return withdrawAddress;}

  public void setWithdrawAddress(String withdrawAddress) {this.withdrawAddress = withdrawAddress;}

  public List<String> getReturnAddresses() {return returnAddresses;}

  public void setReturnAddresses(List<String> returnAddresses) {this.returnAddresses = returnAddresses;}

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

}
