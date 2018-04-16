package main.model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    private String type;
    private int passengerCapacity;
    private String zone;
    private String withdrawAddress;
    private List<String> returnAddresses;
    private String description;
    private String contactPhone;
    private float rentFeeDay;
    private float rentFeeHour;

    //Default vehicle. Change
    public Vehicle(){
      this.type = "Car";
      this.passengerCapacity = 4;
      this.zone = "Default";
      this.withdrawAddress = "Default";
      this.returnAddresses = new ArrayList<String>();
      this.description = "Default";
      this.contactPhone = "00000000";
      this.rentFeeDay = 0;
      this.rentFeeHour = 0;
    }
}
