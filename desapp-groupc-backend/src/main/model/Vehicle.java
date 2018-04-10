package main.model;

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

    public void setType(String type) {
        this.type = type;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }

    public void setReturnAddresses(List<String> returnAddresses) {
        this.returnAddresses = returnAddresses;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setRentFeeDay(float rentFeeDay) {
        this.rentFeeDay = rentFeeDay;
    }

    public void setRentFeeHour(float rentFeeHour) {
        this.rentFeeHour = rentFeeHour;
    }
}
