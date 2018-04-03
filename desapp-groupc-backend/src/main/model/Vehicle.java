package main.model;

import org.joda.time.DateTime;

import java.util.List;

public class Vehicle {

    private VehicleType type;
    private int passengerCapacity;
    private String zone;
    private Address withdrawAddress;
    private List<Address> returnAddresses;
    private String description;
    private Phone contactPhone;
    private float rentFeeDay;
    private float rentFeeHour;

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setWithdrawAddress(Address withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }

    public void setReturnAddresses(List<Address> returnAddresses) {
        this.returnAddresses = returnAddresses;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactPhone(Phone contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setRentFeeDay(float rentFeeDay) {
        this.rentFeeDay = rentFeeDay;
    }

    public void setRentFeeHour(float rentFeeHour) {
        this.rentFeeHour = rentFeeHour;
    }
}
